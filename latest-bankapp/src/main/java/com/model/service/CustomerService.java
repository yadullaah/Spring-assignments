package com.model.service;

import org.springframework.data.domain.Page;
import com.model.Dto.CustomerDto;

public interface CustomerService {

//	List<Customer> getAllCustomers();
//	Customer getCustomerById(int customerId);

	Page<CustomerDto> getAllCustomers(int pageNumber, int pageSize);

	CustomerDto addCustomer(CustomerDto customerDto);

	CustomerDto updateCustomer(CustomerDto customerDto);

	CustomerDto getCustomerById(int customerId);

}
