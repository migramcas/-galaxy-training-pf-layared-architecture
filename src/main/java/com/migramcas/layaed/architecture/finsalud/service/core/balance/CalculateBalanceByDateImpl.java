package com.migramcas.layaed.architecture.finsalud.service.core.balance;

import com.migramcas.layaed.architecture.finsalud.entity.core.application.Goal;
import com.migramcas.layaed.architecture.finsalud.entity.core.application.GoalId;
import com.migramcas.layaed.architecture.finsalud.entity.core.application.Transaction;
import com.migramcas.layaed.architecture.finsalud.entity.core.application.TransactionType;
import com.migramcas.layaed.architecture.finsalud.entity.core.identity.User;
import com.migramcas.layaed.architecture.finsalud.repository.mysql.GoalRepository;
import com.migramcas.layaed.architecture.finsalud.repository.mysql.TransactionRepository;
import com.migramcas.layaed.architecture.finsalud.service.dto.BalanceDTO;
import com.migramcas.layaed.architecture.finsalud.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
public class CalculateBalanceByDateImpl implements CalculateBalanceByDate {

    private final GoalRepository goalRepository;
    private final TransactionRepository transactionRepository;

    @Autowired
    public CalculateBalanceByDateImpl(GoalRepository goalRepository, TransactionRepository transactionRepository) {
        this.goalRepository = goalRepository;
        this.transactionRepository = transactionRepository;
    }

    @Override
    public BalanceDTO execute(User user, LocalDate queryDate) throws ServiceException {
        List<Goal> goalsApplicableQueriedDate = goalRepository.getAllByUserId(user.getId())
                .stream()
                .filter(goal -> goal.getStartDate().isBefore(queryDate) && goal.getEndDate().isAfter(queryDate))
                .toList();

        List<GoalId> idsGoalsApplicable = goalsApplicableQueriedDate
                .stream()
                .map(Goal::getId)
                .toList();

        List<Transaction> transactions = transactionRepository.getAllByGoals(idsGoalsApplicable);

        Map<Boolean, List<Transaction>> transactionsByType = transactions.stream()
                .collect(Collectors.partitioningBy(t -> t.getType().equals(TransactionType.INCOME)));

        BigDecimal totalIncome = transactionsByType.get(true)
                .stream()
                .map(Transaction::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal totalExpense = transactionsByType.get(false)
                .stream()
                .map(Transaction::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return BalanceDTO.builder()
                .totalIncome(totalIncome)
                .totalExpense(totalExpense)
                .balance(totalIncome.subtract(totalExpense))
                .build();
    }

}
