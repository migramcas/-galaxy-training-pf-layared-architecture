package com.migramcas.layaed.architecture.finsalud.service.base;

import com.migramcas.layaed.architecture.finsalud.service.exception.ServiceException;

@FunctionalInterface
public interface ProcessingService<T, R> {

    R execute(T t) throws ServiceException;

}
