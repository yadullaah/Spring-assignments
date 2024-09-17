package com.model.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.model.entity.Student;
import com.model.service.StudentService;

@RestController
@RequestMapping("/app")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping("/students")
	public ResponseEntity<List<Student>> getAllStudents() {
		return ResponseEntity.ok(studentService.getAllStudents());

	}

	@GetMapping("/students/{rollnumber}")
	public ResponseEntity<Student> getStudent(@PathVariable int rollnumber) {
		return ResponseEntity.ok(studentService.getStudent(rollnumber));

	}

	@GetMapping("/studentsname")
	public ResponseEntity<List<Student>> getStudentsByName(@RequestParam String Name) {
		return ResponseEntity.ok(studentService.getStudentsByName(Name));

	}
	
	@GetMapping("/studentsage")
	public ResponseEntity<List<Student>> getStudentsByAge(@RequestParam int age) {
		return ResponseEntity.ok(studentService.getStudentsByAge(age));

	}

	@PostMapping("/students")
	public String addStudent(@RequestBody Student student) {

		studentService.addStudent(student);
		return "Student added successfully";

	}

	@PostMapping("/updatestudent")
	public String updateStudent(@RequestBody Student student) {

		studentService.updateStudent(student);
		return "Student updated successfully";

	}

}
