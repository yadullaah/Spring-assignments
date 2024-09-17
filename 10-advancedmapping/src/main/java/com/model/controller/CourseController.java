package com.model.controller;

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

import com.model.dto.CourseDto;
import com.model.mapping.service.CourseService;

@RestController
@RequestMapping("/studentsapp")
public class CourseController {

	@Autowired
	private CourseService courseService;

	@PostMapping("/courses")
	public ResponseEntity<CourseDto> addNewCourse(@RequestBody CourseDto courseDto) {
		return ResponseEntity.ok(courseService.addCourse(courseDto));

	}

	@GetMapping("/courses")
	public ResponseEntity<List<CourseDto>> getAllCourses() {
		return ResponseEntity.ok(courseService.getAllCourses());

	}

	@GetMapping("/courses/{courseId}")
	public ResponseEntity<CourseDto> getCoursebyId(@PathVariable int courseId) {
		return ResponseEntity.ok(courseService.getCourseById(courseId));
	}
	
	@PostMapping("/courses/instructor")
	public ResponseEntity<CourseDto> assignInstructor(@RequestParam int courseId,@RequestParam int instructorId){
		
		return ResponseEntity.ok(courseService.assignInstructor(courseId, instructorId));
	}

}
