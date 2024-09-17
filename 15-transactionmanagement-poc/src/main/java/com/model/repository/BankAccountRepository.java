package com.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.entity.BankAccount;

public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {
}

