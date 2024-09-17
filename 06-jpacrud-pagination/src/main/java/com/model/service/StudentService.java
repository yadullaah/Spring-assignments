package com.model.service;

import java.util.Optional;

import org.springframework.data.domain.Page;

import com.model.dto.PageResponseDto;
import com.model.entity.Student;

public interface StudentService {

//	List<Student> getAllStudents();

	PageResponseDto getAllStudents( int pageSize , int pageNumber);
	
//	PageResponseDto getStudentsByName(String name, int pageNumber, int pageSize);
	

//	Student addStudent(Student student);

//	Student updateStudent(Student student);

//	Optional<Student> getStudent(int rollnumber);

//	List<Student> findByName(String name);
//	Student findByName(String name);

//	Page<Student> getAllStudentsPage(String name, int pageSize, int pageNumber);
}
