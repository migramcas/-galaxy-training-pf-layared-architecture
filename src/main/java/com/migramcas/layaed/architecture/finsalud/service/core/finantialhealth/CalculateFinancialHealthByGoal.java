package com.migramcas.layaed.architecture.finsalud.service.core.finantialhealth;

import com.migramcas.layaed.architecture.finsalud.command.CalculateHealthCommand;
import com.migramcas.layaed.architecture.finsalud.entity.core.enums.FinancialHealth;
import com.migramcas.layaed.architecture.finsalud.service.exception.ConsultaNoAutorizadaException;
import com.migramcas.layaed.architecture.finsalud.service.exception.GoalNotFoundException;
import com.migramcas.layaed.architecture.finsalud.service.exception.SinTransaccionesRegistradasException;

@FunctionalInterface
public interface CalculateFinancialHealthByGoal {
    FinancialHealth execute(CalculateHealthCommand t) throws GoalNotFoundException, ConsultaNoAutorizadaException, SinTransaccionesRegistradasException;
}
