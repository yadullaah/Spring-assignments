package com.model.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.model.dto.PageResponseDto;
import com.model.dto.StudentDto;
import com.model.entity.Address;
import com.model.entity.Student;
import com.model.mapping.service.StudentService;

@RestController
@RequestMapping("/studentsapp")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@PostMapping("/addstudent")
	public ResponseEntity<Student> addNewStudent(@RequestBody Student student) {
		return ResponseEntity.ok(studentService.addStudent(student));
	}

	@GetMapping("/students")
	public ResponseEntity<PageResponseDto> getAllStudents(@RequestParam int pageSize, @RequestParam int pageNumber) {
		return ResponseEntity.ok(studentService.getAllStudents(pageSize, pageNumber));

	}

	@GetMapping("/studentaddress")
	public ResponseEntity<Address> getAddressByRollnumber(@RequestParam int rollnumber) {
		return ResponseEntity.ok(studentService.getAddressByRollnumber(rollnumber));
	}

	@PostMapping("/student/updateaddress")
	public ResponseEntity<Address> updateStudentAddress(@RequestParam int rollnumber, @RequestBody Address newAddress) {
		return ResponseEntity.ok(studentService.updateAddress(rollnumber, newAddress));
	}

	@PutMapping("/students/courses")
	public ResponseEntity<StudentDto> assignCourses(@RequestParam int rollnumber,
			@RequestBody List<Integer> courseIds) {
		return ResponseEntity.ok(studentService.assignCourses(rollnumber, courseIds));

	}

}
