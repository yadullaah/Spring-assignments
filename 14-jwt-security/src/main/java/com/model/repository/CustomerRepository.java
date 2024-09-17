package com.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
