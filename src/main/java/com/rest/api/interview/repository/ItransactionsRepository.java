package com.rest.api.interview.repository;

import com.rest.api.interview.model.Transactions;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ItransactionsRepository extends JpaRepository<Transactions, Long> {}