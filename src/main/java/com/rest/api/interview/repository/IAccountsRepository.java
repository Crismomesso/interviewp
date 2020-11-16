package com.rest.api.interview.repository;

import com.rest.api.interview.model.Accounts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IAccountsRepository extends JpaRepository<Accounts, Long> {}