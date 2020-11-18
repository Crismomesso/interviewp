package com.rest.api.interview.controller;

import com.rest.api.interview.dto.AccountDTO;
import com.rest.api.interview.exception.ConstraintsViolationException;
import com.rest.api.interview.exception.EntityNotFoundException;
import com.rest.api.interview.service.IAccountsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/accounts")
public class AccountsController {

    private IAccountsService accountsServices;

    @Autowired
    public AccountsController(IAccountsService accountsServices) {
        this.accountsServices = accountsServices;
    }

    
    /** 
     * @param dto
     * @return AccountDTO
     * @throws ConstraintsViolationException
     */
    @PostMapping
    @ApiOperation(value = "Insert account")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public AccountDTO create(@RequestBody AccountDTO dto) throws ConstraintsViolationException {
        return accountsServices.create(dto);
    }

    
    /** 
     * @param accountId
     * @return AccountDTO
     * @throws EntityNotFoundException
     */
    @GetMapping("/{accountId}")
    @ApiOperation(value = "Find account by id")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public AccountDTO get(@PathVariable Long accountId) throws EntityNotFoundException {
        return accountsServices.findById(accountId);
    }
}