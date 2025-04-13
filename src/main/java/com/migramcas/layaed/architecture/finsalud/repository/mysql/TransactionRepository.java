package com.migramcas.layaed.architecture.finsalud.repository.mysql;

import com.migramcas.layaed.architecture.finsalud.entity.core.application.GoalId;
import com.migramcas.layaed.architecture.finsalud.entity.core.application.Transaction;
import com.migramcas.layaed.architecture.finsalud.entity.core.application.TransactionId;
import com.migramcas.layaed.architecture.finsalud.repository.base.GenericRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends GenericRepository<Transaction, TransactionId> {

    @Query("SELECT COALESCE(MAX(t.id.value), 0) + 1 FROM Transaction t")
    Integer getNextId();

    @Query("SELECT t FROM Transaction t WHERE t.goalId = :goalId")
    List<Transaction> getAllByGoalId(GoalId goalId);

    @Query("SELECT t FROM Transaction t WHERE t.goalId IN :goalsIds")
    List<Transaction> getAllByGoals(List<GoalId> goalsIds);

}
