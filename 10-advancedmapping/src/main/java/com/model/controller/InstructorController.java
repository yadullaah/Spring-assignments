package com.model.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.model.dto.InstructorDto;
import com.model.entity.Instructor;
import com.model.mapping.service.InstructorService;

@RestController
@RequestMapping("/studentsapp")
public class InstructorController {

	@Autowired
	private InstructorService instructorService;

	@PostMapping("/instructor")
	public ResponseEntity<InstructorDto> addNewInstructor(@RequestBody InstructorDto instructorDto) {
		return ResponseEntity.ok(instructorService.addInstructor(instructorDto));

	}

	@GetMapping("/instructors")
	public ResponseEntity<List<InstructorDto>> getAllInstructors() {
		return ResponseEntity.ok(instructorService.getAllInstructors());

	}

	@GetMapping("/instructors/{id}")
	public ResponseEntity<InstructorDto> getInstructorDtobyId(@PathVariable int instructorId) {
		return ResponseEntity.ok(instructorService.getInstructorById(instructorId));
	}

	@PutMapping("/instructors/courses")
	public ResponseEntity<Instructor> allocateCourses(@RequestParam int instructorId,
			@RequestBody List<Integer> courseIds) {
		return ResponseEntity.ok(instructorService.allocateCourses(instructorId, courseIds));
	}

	
}
