package com.model.controller;

import com.model.dto.EmployeeDto;
import com.model.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping
	public ResponseEntity<Page<EmployeeDto>> getAllEmployees(@RequestParam int pageNumber, @RequestParam int pageSize) {
		return ResponseEntity.ok(employeeService.getAllEmployees(pageNumber, pageSize));
	}

	@GetMapping("/{employeeId}")
	public ResponseEntity<Optional<EmployeeDto>> getEmployeeById(@PathVariable int employeeId) {
		return ResponseEntity.ok(employeeService.getEmployeeById(employeeId));
	}

	@PostMapping
	public ResponseEntity<EmployeeDto> addEmployee(@RequestBody EmployeeDto employeeDto) {
		return ResponseEntity.ok(employeeService.addEmployee(employeeDto));
	}

	@PutMapping
	public ResponseEntity<EmployeeDto> updateEmployee(@RequestBody EmployeeDto employeeDto) {
		return ResponseEntity.ok(employeeService.updateEmployee(employeeDto));
	}

	@DeleteMapping("/{employeeId}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable int employeeId) {
		employeeService.deleteEmployee(employeeId);
		return ResponseEntity.noContent().build();
	}
}
