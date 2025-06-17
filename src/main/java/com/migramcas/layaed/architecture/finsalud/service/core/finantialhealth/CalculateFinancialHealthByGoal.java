package com.migramcas.layaed.architecture.finsalud.service.core.finantialhealth;

import com.migramcas.layaed.architecture.finsalud.entity.core.application.FinancialHealth;
import com.migramcas.layaed.architecture.finsalud.service.command.CalculateHealthCommand;
import com.migramcas.layaed.architecture.finsalud.service.exception.GoalNotFoundException;
import com.migramcas.layaed.architecture.finsalud.service.exception.NoTransactionsFoundException;
import com.migramcas.layaed.architecture.finsalud.service.exception.QueryNotAllowedException;

@FunctionalInterface
public interface CalculateFinancialHealthByGoal {
    FinancialHealth execute(CalculateHealthCommand t) throws GoalNotFoundException, QueryNotAllowedException, NoTransactionsFoundException;
}
