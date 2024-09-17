package com.model.service;

import java.util.List;

import com.model.entity.Student;

public interface StudentService {
	
	List<Student> getAllStudents();
	Student getStudent(int rollnumber);
	void addStudent(Student student);
	void updateStudent (Student student);
	List<Student> getStudentsByName(String name);
	List<Student> getStudentsByAge(int age);

}
