package com.model.repository;

import com.model.entity.Salary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaryRepository extends JpaRepository<Salary, Integer> {
   
    Page<Salary> findBySalaryMonth(String salaryMonth, Pageable pageable);
}
