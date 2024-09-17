package com.model.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.model.entity.Customer;
import com.model.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepo;

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepo.getAllCustomers();
    }

    @Override
    public Customer getCustomer(int customerId) {
        return customerRepo.getCustomer(customerId);
    }

    @Override
    public void addCustomer(Customer customer) {
        customerRepo.addCustomer(customer);
    }
}
