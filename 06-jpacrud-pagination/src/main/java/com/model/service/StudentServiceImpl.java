package com.model.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.model.Repository.StudentRepository;
import com.model.dto.PageResponseDto;
import com.model.entity.Student;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepo;

	@Override
	public PageResponseDto getAllStudents( int pageSize ,int pageNumber) {

		Pageable pageable = PageRequest.of(pageNumber, pageSize);

		Page<Student> studentPage = studentRepo.findAll(pageable);

		PageResponseDto studentPageDto = new PageResponseDto();
		studentPageDto.setTotalPages(studentPage.getTotalPages());
		studentPageDto.setTotalElements(studentPage.getTotalElements());
		studentPageDto.setSize(studentPage.getSize());
		studentPageDto.setContent(studentPage.getContent());

		return studentPageDto;
	}

//	@Override
//	public Page<Student> getAllStudents(int pageNumber, int pageSize) {
//
//		Pageable pageable = PageRequest.of(pageNumber, pageSize);
//		return studentRepo.findAll(pageable);
//	}

//	@Override
//	public Student addStudent(Student student) {
//
//		return studentRepo.save(student);
//	}
//
//	@Override
//	public Page<Student> getAllStudentsPage(String name, int pageSize, int pageNumber) {
//		Pageable pageable = PageRequest.of(pageNumber, pageSize);
//		return studentRepo.findByName(name, pageable);
//
//	}
//
//	@Override
//	public Student updateStudent(Student student) {
//
//		return studentRepo.save(student);
//	}
//
//	@Override
//	public Optional<Student> getStudent(int rollnumber) {
//
//		return studentRepo.findById(rollnumber);
//	}
//
//	@Override
//	public Student findByName(String name) {
//		// TODO Auto-generated method stub
//		return studentRepo.findByName(name);
//	}

//	@Override
//	public PageResponseDto getStudentsByName(String name, int pageNumber, int pageSize) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
