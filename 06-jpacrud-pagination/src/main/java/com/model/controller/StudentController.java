package com.model.controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.model.dto.PageResponseDto;
import com.model.entity.Student;
import com.model.service.StudentService;

@RestController
@RequestMapping("/studentapp")
public class StudentController {

    @Autowired
    private StudentService studentservice;
    
	
	@GetMapping("/students")
	public ResponseEntity<PageResponseDto> getAllStudents(@RequestParam (required = false) String name ,@RequestParam int pageSize, @RequestParam int pageNumber ) {
		
		if(name!= null)
			return ResponseEntity.ok(studentservice.getAllStudents(pageSize,pageNumber));
		return null;
		
		
	}
	
	//return ResponseEntity.ok(studentservice.getAllStudentsByName(name,pageNumber,pageSize));

	
//	@GetMapping("/students")
//	public ResponseEntity<Page<Student>> getAllStudents(@RequestParam (required = false) String name , @RequestParam int pageNumber , @RequestParam int pageSize) {
//		
//		if(name!= null)
//			return ResponseEntity.ok(studentservice.getAllStudentsPage(name,pageSize,pageNumber));
//		
//		return ResponseEntity.ok(studentservice.getAllStudents(pageNumber,pageSize));
//	}
	
//	@PostMapping("/students")
//	public String addStudent(@RequestBody Student student) {
//		ResponseEntity.ok(studentservice.addStudent(student));
//		return "student added";
//	}
//	
//	@PutMapping("/students")
//	public String updateStudent(@RequestBody Student student) {
//		ResponseEntity.ok(studentservice.updateStudent(student));
//		return "student updated";
//	}
//	
//	@GetMapping("/students/{rollnumber}")
//	public ResponseEntity<Optional<Student>> getStudent(@PathVariable int rollnumber) {
//		
//		return ResponseEntity.ok( studentservice.getStudent(rollnumber));
//	}
//	
//
//	@GetMapping("/students-name/{name}")
//	public ResponseEntity<Student> getStudentsByName(@PathVariable String name) {
//		return ResponseEntity.ok(studentservice.findByName(name));
//	}
//	
	
}
