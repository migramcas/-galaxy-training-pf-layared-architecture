package com.migramcas.layaed.architecture.finsalud.service.core.auth;

import com.migramcas.layaed.architecture.finsalud.service.exception.UserNotFoundException;

@FunctionalInterface
public interface EnableAccountService {
    void execute(String email, String password) throws UserNotFoundException;

}
