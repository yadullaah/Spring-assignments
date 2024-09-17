package com.model.Repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

	@Autowired
	private EntityManager manager;

	@Override
	public List<Employee> getAllEmployees() {

		TypedQuery<Employee> query = manager.createQuery("select e from Employee e", Employee.class);
		return query.getResultList();
	}

}
