package com.migramcas.layaed.architecture.finsalud.service.base;

@FunctionalInterface
public interface ExecutionService<T> {

    void execute(T t) throws ServiceException;

}
