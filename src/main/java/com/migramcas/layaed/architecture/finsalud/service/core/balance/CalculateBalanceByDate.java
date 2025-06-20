package com.migramcas.layaed.architecture.finsalud.service.core.balance;

import com.migramcas.layaed.architecture.finsalud.entity.core.identity.User;
import com.migramcas.layaed.architecture.finsalud.service.dto.BalanceDTO;
import com.migramcas.layaed.architecture.finsalud.service.exception.ServiceException;

import java.time.LocalDate;

@FunctionalInterface
public interface CalculateBalanceByDate {

    BalanceDTO execute(User user, LocalDate queryDate) throws ServiceException;

}
