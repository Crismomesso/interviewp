package com.rest.api.interview.service;

import java.util.Collection;

import com.rest.api.interview.exception.ConstraintsViolationException;
import com.rest.api.interview.exception.EntityNotFoundException;
import com.rest.api.interview.exception.InternalServerErrorExeption;

/**
 * IBasicService
 */
public interface IBasicService<T> {
    Collection<T> get(int page, int size);
    T create(T obj) throws ConstraintsViolationException;
    T findById(Long id) throws EntityNotFoundException;
    void deleteById(Long id) throws InternalServerErrorExeption;
    T alter(long id, T clientDto) throws ConstraintsViolationException, EntityNotFoundException;
}