package com.model.service;

import com.model.dto.EmployeeDto;
import com.model.entity.Employee;
import com.model.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Page<EmployeeDto> getAllEmployees(int pageNumber, int pageSize) {
		return employeeRepository.findAll(PageRequest.of(pageNumber, pageSize))
				.map(employee -> new EmployeeDto(employee.getEmployeeId(), employee.getFirstName(),
						employee.getLastName(), employee.getPhoneNumber(), employee.getEmail(), employee.getPosition(),
						employee.getHireDate(), employee.getSalary(), employee.getAccountNumber(), employee.getStatus(),
						employee.getClient().getClientId()));
	}

	@Override
	public Optional<EmployeeDto> getEmployeeById(int employeeId) {
		return employeeRepository.findById(employeeId)
				.map(employee -> new EmployeeDto(employee.getEmployeeId(), employee.getFirstName(),
						employee.getLastName(), employee.getPhoneNumber(), employee.getEmail(), employee.getPosition(),
						employee.getHireDate(), employee.getSalary(), employee.getAccountNumber(), employee.getStatus(),
						employee.getClient().getClientId()));
	}

	@Override
	public EmployeeDto addEmployee(EmployeeDto employeeDto) {
		Employee employee = new Employee(employeeDto.getEmployeeId(), employeeDto.getFirstName(),
				employeeDto.getLastName(), employeeDto.getPhoneNumber(), employeeDto.getEmail(),
				employeeDto.getPosition(), employeeDto.getHireDate(), employeeDto.getSalary(),
				employeeDto.getAccountNumber(), employeeDto.getStatus(), null); // Handle Client association

		Employee savedEmployee = employeeRepository.save(employee);
		return new EmployeeDto(savedEmployee.getEmployeeId(), savedEmployee.getFirstName(), savedEmployee.getLastName(),
				savedEmployee.getPhoneNumber(), savedEmployee.getEmail(), savedEmployee.getPosition(),
				savedEmployee.getHireDate(), savedEmployee.getSalary(), savedEmployee.getAccountNumber(),
				savedEmployee.getStatus(), savedEmployee.getClient().getClientId());
	}

	@Override
	public EmployeeDto updateEmployee(EmployeeDto employeeDto) {
		Employee employee = new Employee(employeeDto.getEmployeeId(), employeeDto.getFirstName(),
				employeeDto.getLastName(), employeeDto.getPhoneNumber(), employeeDto.getEmail(),
				employeeDto.getPosition(), employeeDto.getHireDate(), employeeDto.getSalary(),
				employeeDto.getAccountNumber(), employeeDto.getStatus(), null); // Handle Client association

		Employee updatedEmployee = employeeRepository.save(employee);
		return new EmployeeDto(updatedEmployee.getEmployeeId(), updatedEmployee.getFirstName(),
				updatedEmployee.getLastName(), updatedEmployee.getPhoneNumber(), updatedEmployee.getEmail(),
				updatedEmployee.getPosition(), updatedEmployee.getHireDate(), updatedEmployee.getSalary(),
				updatedEmployee.getAccountNumber(), updatedEmployee.getStatus(),
				updatedEmployee.getClient().getClientId());
	}

	@Override
	public void deleteEmployee(int employeeId) {
		employeeRepository.deleteById(employeeId);
	}
}
