package com.model.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.model.entity.Account;
import com.model.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

	List<Transaction> findByAccount(Account account);

}
