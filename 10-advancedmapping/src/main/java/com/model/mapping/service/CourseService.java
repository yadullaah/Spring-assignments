package com.model.mapping.service;

import java.util.List;

import com.model.dto.CourseDto;

public interface CourseService {

	CourseDto addCourse(CourseDto courseDto);
	
	List<CourseDto> getAllCourses();
	
	CourseDto getCourseById (int courseId);

	CourseDto assignInstructor(int courseId, int instructorId);

}
