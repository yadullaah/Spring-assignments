package com.model.repository;

import com.model.entity.SalaryAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaryAccountRepository extends JpaRepository<SalaryAccount, Long> {
}
