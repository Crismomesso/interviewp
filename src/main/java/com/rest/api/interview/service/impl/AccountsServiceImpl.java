package com.rest.api.interview.service.impl;

import java.util.Collection;

import com.rest.api.interview.dto.AccountDTO;
import com.rest.api.interview.exception.ConstraintsViolationException;
import com.rest.api.interview.exception.EntityNotFoundException;
import com.rest.api.interview.exception.InternalServerErrorExeption;
import com.rest.api.interview.mapper.AccountsMapper;
import com.rest.api.interview.model.Accounts;
import com.rest.api.interview.repository.IAccountsRepository;
import com.rest.api.interview.service.IAccountsService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class AccountsServiceImpl implements IAccountsService {

    public static final String NOT_SUPPORTED = "Not supported yet.";

    private static final Logger LOG = LoggerFactory.getLogger(AccountsServiceImpl.class);

    private IAccountsRepository repository;

    @Autowired
    public AccountsServiceImpl(IAccountsRepository repository) {
        this.repository = repository;
    }

    @Override
    public Collection<AccountDTO> get(int page, int size) {
        throw new UnsupportedOperationException(NOT_SUPPORTED);
    }

    @Override
    public AccountDTO create(AccountDTO obj) throws ConstraintsViolationException {
        try {
            Accounts model = repository.save(AccountsMapper.convertToEntity(obj));
            return AccountsMapper.convertToDTO(model);
        } catch (DataIntegrityViolationException e) {
            LOG.warn("ConstraintsViolationException to account user: {}", obj, e);
            throw new ConstraintsViolationException(e.getMessage());
        }
    }

    @Override
    public AccountDTO findById(Long id) throws EntityNotFoundException {
        Accounts ent = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Account not found: " + id));
        return AccountsMapper.convertToDTO(ent);
    }

    @Override
    public void deleteById(Long id) throws InternalServerErrorExeption {
        throw new UnsupportedOperationException(NOT_SUPPORTED);
    }

    @Override
    public AccountDTO alter(long id, AccountDTO clientDto)
            throws ConstraintsViolationException, EntityNotFoundException {
        throw new UnsupportedOperationException(NOT_SUPPORTED);
    }

}
