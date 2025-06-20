package com.migramcas.layaed.architecture.finsalud.service.exception;

public class ServiceException extends Exception {

    Integer status = 500;

    private static final long serialVersionUID = 2886621070626913719L;

    public ServiceException() {
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Integer status) {
        super(message);
        this.status = status;
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }


    public ServiceException(String message, Throwable cause, Integer status) {
        super(message, cause);
        this.status = status;
    }

    public ServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public Integer getStatus() {
        return status;
    }
}
