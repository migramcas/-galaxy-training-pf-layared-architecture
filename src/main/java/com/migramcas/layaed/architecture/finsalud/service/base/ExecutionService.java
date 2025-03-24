package com.migramcas.layaed.architecture.finsalud.service.base;

import com.migramcas.layaed.architecture.finsalud.service.exception.ServiceException;

@FunctionalInterface
public interface ExecutionService<T> {

    void execute(T t) throws ServiceException;

}
