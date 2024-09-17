package com.model.repository;

import com.model.entity.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BankRepository extends JpaRepository<Bank, Integer> {

    Page<Bank> findByBankName(String bankName, Pageable pageable);
}
