package com.migramcas.layaed.architecture.finsalud.service.exception;

public class GoalNotFoundException extends ServiceException {

    public GoalNotFoundException(String message) {
        super(message, 404);
    }

}
