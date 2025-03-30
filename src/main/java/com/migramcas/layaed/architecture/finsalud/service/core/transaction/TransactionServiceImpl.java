package com.migramcas.layaed.architecture.finsalud.service.core.transaction;

import com.migramcas.layaed.architecture.finsalud.controller.dto.TransactionCommand;
import com.migramcas.layaed.architecture.finsalud.entity.core.application.Transaction;
import com.migramcas.layaed.architecture.finsalud.entity.core.application.TransactionId;
import com.migramcas.layaed.architecture.finsalud.repository.mysql.TransactionRepository;
import com.migramcas.layaed.architecture.finsalud.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService<TransactionCommand, Transaction, TransactionId> {

    TransactionRepository transactionRepository;

    @Autowired
    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public List<TransactionCommand> getAll() throws ServiceException {
        return null;
    }

    @Override
    public Optional<TransactionCommand> getById(TransactionId transactionId) throws ServiceException {
        return Optional.empty();
    }

    @Override
    public Transaction add(TransactionCommand transactionCommand) throws ServiceException {
        Transaction transaction = Transaction
                .builder()
                .id(TransactionId.of(transactionRepository.getNextId()))
                .goalId(transactionCommand.getGoalId())
                .name(transactionCommand.getName())
                .type(transactionCommand.getType())
                .amount(transactionCommand.getAmount())
                .userId(transactionCommand.getUser().getId())
                .active(true)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
        return transactionRepository.saveAndFlush(transaction);
    }

    @Override
    public Transaction update(TransactionCommand transactionCommand) throws ServiceException {
        return null;
    }

    @Override
    public void delete(TransactionCommand transactionCommand) throws ServiceException {

    }
}
