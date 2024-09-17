package com.model.repository;

import com.model.entity.SalaryTransaction;
import com.model.enums.StatusTransaction;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaryTransactionRepository extends JpaRepository<SalaryTransaction, Integer> {
 
    Page<SalaryTransaction> findByStatus(StatusTransaction status, Pageable pageable);
}
