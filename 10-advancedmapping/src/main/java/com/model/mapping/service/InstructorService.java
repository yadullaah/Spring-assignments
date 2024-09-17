package com.model.mapping.service;

import java.util.List;

import com.model.dto.InstructorDto;
import com.model.entity.Instructor;

public interface InstructorService {

	InstructorDto addInstructor(InstructorDto instructorDto);

	InstructorDto getInstructorById(int instructorId);

	List<InstructorDto> getAllInstructors();

	Instructor allocateCourses(int instructorId, List<Integer> courseIds);

}
