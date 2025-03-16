package com.migramcas.layaed.architecture.finsalud.service.core.goals;

import com.migramcas.layaed.architecture.finsalud.entity.core.Transaction;
import com.migramcas.layaed.architecture.finsalud.entity.core.TransactionId;
import com.migramcas.layaed.architecture.finsalud.service.base.ServiceException;

import java.util.List;
import java.util.Optional;

public class GoalServiceImpl implements GoalService {

    @Override
    public List<Transaction> getAll() throws ServiceException {
        return null;
    }

    @Override
    public Optional<Transaction> getById(TransactionId transactionId) throws ServiceException {
        return Optional.empty();
    }

    @Override
    public void add(Transaction transaction) throws ServiceException {

    }

    @Override
    public void update(Transaction transaction) throws ServiceException {

    }

    @Override
    public void delete(Transaction transaction) throws ServiceException {

    }
    
}
