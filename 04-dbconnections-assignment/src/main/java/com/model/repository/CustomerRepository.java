package com.model.repository;

import java.util.List;
import com.model.entity.Customer;

public interface CustomerRepository {

    List<Customer> getAllCustomers();
    
    Customer getCustomer(int customerId);
    
    void addCustomer(Customer customer);
}
