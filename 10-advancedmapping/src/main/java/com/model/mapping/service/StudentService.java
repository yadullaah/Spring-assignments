package com.model.mapping.service;

import java.util.List;

import com.model.dto.PageResponseDto;
import com.model.dto.StudentDto;
import com.model.entity.Address;
import com.model.entity.Course;
import com.model.entity.Student;

public interface StudentService {

	Student addStudent(Student student);

	//PageResponseDto getAllStudents(int pageSize, int pageNumber);
	
	Address getAddressByRollnumber(int rollnumber);
	
	Address updateAddress(int rollnumber, Address newAddress);
	
	StudentDto getStudentByRollNumber(int rollnumber);
	
	PageResponseDto <StudentDto> getAllStudents (int pageNumber, int pageSize);

	StudentDto assignCourses (int rollnumber, List<Integer> courses);
}
