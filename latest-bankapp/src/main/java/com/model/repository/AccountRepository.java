package com.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
	
	boolean existsByAccountNumber(long accountNumber);

}
