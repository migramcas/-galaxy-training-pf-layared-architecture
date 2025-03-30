package com.migramcas.layaed.architecture.finsalud.service.core.finantialhealth;

import com.migramcas.layaed.architecture.finsalud.command.CalculateHealthCommand;
import com.migramcas.layaed.architecture.finsalud.entity.core.application.Goal;
import com.migramcas.layaed.architecture.finsalud.entity.core.application.Transaction;
import com.migramcas.layaed.architecture.finsalud.entity.core.enums.FinancialHealth;
import com.migramcas.layaed.architecture.finsalud.entity.core.enums.TransactionType;
import com.migramcas.layaed.architecture.finsalud.exception.ConsultaNoAutorizadaException;
import com.migramcas.layaed.architecture.finsalud.exception.GoalNotFoundException;
import com.migramcas.layaed.architecture.finsalud.exception.SinTransaccionesRegistradasException;
import com.migramcas.layaed.architecture.finsalud.repository.mysql.GoalRepository;
import com.migramcas.layaed.architecture.finsalud.repository.mysql.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CalculateFinancialHealthByGoalImpl implements CalculateFinancialHealthByGoal {

    private static BigDecimal ONE_HUNDRED_PERCENT = new BigDecimal(100);
    private static BigDecimal TWENTY_FIVE_PERCENT = new BigDecimal(25);
    private static BigDecimal FIFTY_PERCENT = new BigDecimal(50);
    private static BigDecimal SENVENTY_FIVE_PERCENT = new BigDecimal(75);

    GoalRepository goalRepository;
    TransactionRepository transactionRepository;

    @Autowired
    public CalculateFinancialHealthByGoalImpl(GoalRepository goalRepository, TransactionRepository transactionRepository) {
        this.goalRepository = goalRepository;
        this.transactionRepository = transactionRepository;
    }

    @Override
    public FinancialHealth execute(CalculateHealthCommand cmd) throws GoalNotFoundException, ConsultaNoAutorizadaException, SinTransaccionesRegistradasException {
        Goal goal = goalRepository
                .findById(cmd.getGoalId())
                .orElseThrow(() -> new GoalNotFoundException("La meta que intenta calcular no existe"));

        if (!goal.getUserId().equals(cmd.getUser().getId())) {
            throw new ConsultaNoAutorizadaException("La meta que intenta consultar no está asociada a este usuario");
        }

        List<Transaction> transactions = transactionRepository.getAllByGoalId(goal.getId());
        if (transactions.isEmpty()) {
            throw new SinTransaccionesRegistradasException("No han sido registradas transacciones para esta meta");
        }

        Map<Boolean, List<Transaction>> transactionsByType = transactions.stream()
                .collect(Collectors.partitioningBy(t -> t.getType().equals(TransactionType.INCOME)));

        List<Transaction> incomeTransactions = transactionsByType.get(true);
        List<Transaction> expenseTransactions = transactionsByType.get(false);

        BigDecimal totalIncome = incomeTransactions.stream()
                .map(Transaction::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal totalExpense = expenseTransactions.stream()
                .map(Transaction::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return calculate(totalIncome, totalExpense);
    }


    private FinancialHealth calculate(BigDecimal totalIncome, BigDecimal totalExpense) {
        BigDecimal expensePercentage = (totalExpense.multiply(ONE_HUNDRED_PERCENT)).divide(totalIncome, 2, RoundingMode.HALF_UP);

        return switch (expensePercentage.compareTo(TWENTY_FIVE_PERCENT)) {
            case -1 -> FinancialHealth.EXCELLENT;
            case 0, 1 -> expensePercentage.compareTo(FIFTY_PERCENT) <= 0 ? FinancialHealth.GOOD :
                    expensePercentage.compareTo(SENVENTY_FIVE_PERCENT) <= 0 ? FinancialHealth.FAIR :
                            expensePercentage.compareTo(ONE_HUNDRED_PERCENT) <= 0 ? FinancialHealth.POOR :
                                    FinancialHealth.CRITICAL;
            default -> FinancialHealth.CRITICAL;
        };
    }

}
