package com.model.repository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.model.entity.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

    @Autowired
    private EntityManager manager;

    @Override
    public List<Customer> getAllCustomers() {
        TypedQuery<Customer> query = manager.createQuery("select c from Customer c", Customer.class);
        return query.getResultList();
    }

    @Override
    public Customer getCustomer(int customerId) {
        return manager.find(Customer.class, customerId);
    }

    @Override
    @Transactional
    public void addCustomer(Customer customer) {
        manager.persist(customer);
    }
}
