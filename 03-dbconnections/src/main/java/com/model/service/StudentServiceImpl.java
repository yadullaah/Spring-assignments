package com.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.entity.Student;
import com.model.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepo;

	@Override
	public List<Student> getAllStudents() {

		return studentRepo.getAllStudents();
	}

	@Override
	public Student getStudent(int rollnumber) {
		return studentRepo.getStudent(rollnumber);
	}

	@Override
	public void addStudent(Student student) {
		studentRepo.addStudent(student);
	}

	@Override
	public void updateStudent(Student student) {
		studentRepo.updateStudent(student);
	}

	@Override
	public List<Student> getStudentsByName(String name) {
		
		return studentRepo.getStudentsByName(name);
	}

	@Override
	public List<Student> getStudentsByAge(int age) {
		
		return studentRepo.getStudentsByAge(age);
	}

}
