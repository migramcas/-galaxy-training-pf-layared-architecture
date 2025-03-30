package com.migramcas.layaed.architecture.finsalud.service.base;

import com.migramcas.layaed.architecture.finsalud.service.exception.ServiceException;

import java.util.List;
import java.util.Optional;

public interface CrudService<T, R, ID> {

    List<T> getAll() throws ServiceException;

    Optional<T> getById(ID id) throws ServiceException;

    R add(T t) throws ServiceException;

    R update(T t) throws ServiceException;

    void delete(T t) throws ServiceException;

}