package com.rest.api.interview.service.impl;

import java.util.Collection;

import com.rest.api.interview.dto.TransactionDTO;
import com.rest.api.interview.enums.OperationEnum;
import com.rest.api.interview.exception.ConstraintsViolationException;
import com.rest.api.interview.exception.EntityNotFoundException;
import com.rest.api.interview.exception.InsufficientLimitException;
import com.rest.api.interview.exception.InternalServerErrorExeption;
import com.rest.api.interview.mapper.TransactionsMapper;
import com.rest.api.interview.model.Accounts;
import com.rest.api.interview.model.Transactions;
import com.rest.api.interview.repository.IAccountsRepository;
import com.rest.api.interview.repository.ItransactionsRepository;
import com.rest.api.interview.service.ITransactionsService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class TransactionsServiceImpl implements ITransactionsService {

    private static final Logger LOG = LoggerFactory.getLogger(TransactionsServiceImpl.class);
    public static final String NOT_SUPPORTED = "Not supported yet.";

    private IAccountsRepository repAccount;
    private ItransactionsRepository repository;

    private Transactions convertToEntity;

    @Autowired
    public TransactionsServiceImpl(ItransactionsRepository repository,IAccountsRepository repAccount) {
        this.repository = repository;
        this.repAccount = repAccount;
    }

    public TransactionDTO create(TransactionDTO obj) throws Exception {
        try {
            Transactions entity = TransactionsMapper.convertToEntity(obj);
            Accounts  account =  repAccount.findById(obj.getAccountId()).get();
            entity.setAccountId(account);
            double limit = account.getAvailableCreditLimit();
            account.setAvailableCreditLimit(limit + obj.getAmount());
            validate(obj);
            if(account.getAvailableCreditLimit()<=0){
                throw new InsufficientLimitException("credito insuficiente");
            }          
            return TransactionsMapper.convertToDTO(repository.saveAndFlush(entity));
        } catch (DataIntegrityViolationException e) {
            LOG.warn("ConstraintsViolationException to account user: {}", obj, e);
            throw new ConstraintsViolationException(e.getMessage());
        }
    }

    private void validate(TransactionDTO obj) throws InternalServerErrorExeption {
        if (obj.getOperationTypeId().equals(OperationEnum.PAGAMENTO)) {
            if (obj.getAmount() <= 0) {
                throw new InternalServerErrorExeption("amount negative");
            }
        } else {
            if (obj.getAmount() >= 0) {
                throw new InternalServerErrorExeption("amount pos");
            }
        }

    }

    @Override
    public Collection<TransactionDTO> get(int page, int size) {
        throw new UnsupportedOperationException(NOT_SUPPORTED);
    }

    @Override
    public TransactionDTO findById(Long id) throws EntityNotFoundException {
        throw new UnsupportedOperationException(NOT_SUPPORTED);
    }

    @Override
    public void deleteById(Long id) throws InternalServerErrorExeption {
        throw new UnsupportedOperationException(NOT_SUPPORTED);

    }

    @Override
    public TransactionDTO alter(long id, TransactionDTO clientDto)
            throws ConstraintsViolationException, EntityNotFoundException {
        throw new UnsupportedOperationException(NOT_SUPPORTED);

    }

}
