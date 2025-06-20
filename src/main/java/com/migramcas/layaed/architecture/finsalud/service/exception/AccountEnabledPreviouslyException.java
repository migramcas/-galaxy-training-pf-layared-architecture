package com.migramcas.layaed.architecture.finsalud.service.exception;

public class AccountEnabledPreviouslyException extends ServiceException {

    public AccountEnabledPreviouslyException(String message) {
        super(message, 409);
    }

}
