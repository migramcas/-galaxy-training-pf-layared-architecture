package com.migramcas.layaed.architecture.finsalud.service.base;

@FunctionalInterface
public interface ProcessingService<T, R> {

    R execute(T t) throws ServiceException;

}
