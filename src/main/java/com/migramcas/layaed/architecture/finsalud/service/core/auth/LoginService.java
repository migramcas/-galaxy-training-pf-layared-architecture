package com.migramcas.layaed.architecture.finsalud.service.core.auth;

import com.migramcas.layaed.architecture.finsalud.service.exception.AccountDisabledException;
import com.migramcas.layaed.architecture.finsalud.service.exception.InvalidLoginException;
import com.migramcas.layaed.architecture.finsalud.service.exception.UserNotFoundException;

@FunctionalInterface
public interface LoginService<T, R> {

    R execute(T t) throws UserNotFoundException, AccountDisabledException, InvalidLoginException;

}
