package com.rest.api.interview.controller;

import com.rest.api.interview.dto.TransactionDTO;
import com.rest.api.interview.exception.ConstraintsViolationException;
import com.rest.api.interview.service.ITransactionsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/transactions")
public class TransactionsController {
    
    private ITransactionsService service;

    @Autowired
    public TransactionsController(ITransactionsService service) {
        this.service = service;
    }

    
    /** 
     * @param dto
     * @throws ConstraintsViolationException
     */
    @PostMapping
    @ApiOperation(value = "Insert transaction")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public void create(@RequestBody TransactionDTO dto) throws ConstraintsViolationException {
        service.create(dto);
    }
}
