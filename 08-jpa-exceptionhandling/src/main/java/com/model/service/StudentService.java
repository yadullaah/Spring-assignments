package com.model.service;

import com.model.dto.PageResponseDto;
import com.model.entity.Student;

public interface StudentService {

//	List<Student> getAllStudents();

	PageResponseDto<Student> getAllStudents(int pageNumber, int pageSize);

	PageResponseDto<Student> getAllStudentsPage(String name, int pageSize, int pageNumber);

	Student addStudent(Student student);

	Student updateStudent(Student student);

	Student getStudentByRollNumber(int rollnumber);

//	List<Student> findByName(String name);
	Student findByName(String name);
}
