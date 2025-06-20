package com.migramcas.layaed.architecture.finsalud.service.exception;

public class InvalidLoginException extends ServiceException {

    public InvalidLoginException(String message) {
        super(message, 401);
    }

}
