package com.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Employee findByEmail(String email);
}
