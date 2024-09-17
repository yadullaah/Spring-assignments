package com.model.config;

import org.springframework.batch.item.ItemProcessor;

import com.model.entity.Employee;

public class EmployeeProcessor implements ItemProcessor<Employee, Employee> {

	@Override
	public Employee process(Employee item) throws Exception {
		return item;
	}

}
