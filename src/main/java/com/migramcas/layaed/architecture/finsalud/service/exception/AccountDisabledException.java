package com.migramcas.layaed.architecture.finsalud.service.exception;

public class AccountDisabledException extends ServiceException {

    public AccountDisabledException(String message) {
        super(message, 403);
    }

}
