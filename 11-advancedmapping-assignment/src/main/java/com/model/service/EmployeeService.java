package com.model.service;

import com.model.dto.EmployeeDto;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface EmployeeService {
    Page<EmployeeDto> getAllEmployees(int pageNumber, int pageSize);
    Optional<EmployeeDto> getEmployeeById(int employeeId);
    EmployeeDto addEmployee(EmployeeDto employeeDto);
    EmployeeDto updateEmployee(EmployeeDto employeeDto);
    void deleteEmployee(int employeeId);
}
