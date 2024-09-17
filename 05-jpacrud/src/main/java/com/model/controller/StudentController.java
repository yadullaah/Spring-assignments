package com.model.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.model.entity.Student;
import com.model.service.StudentService;

@RestController
@RequestMapping("/studentapp")
public class StudentController {

    @Autowired
    private StudentService studentservice;

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok(studentservice.getAllStudents());
    }

	@GetMapping("/students/{rollnumber}")
	public ResponseEntity<Student> getStudentById(@PathVariable int rollnumber) {
		return ResponseEntity.ok(studentservice.getStudentById(rollnumber));

	}

    @PostMapping("/students")
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        Student newStudent = studentservice.addStudent(student);
        return ResponseEntity.ok(newStudent);
    }
}
