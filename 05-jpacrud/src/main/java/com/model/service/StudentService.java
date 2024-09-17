package com.model.service;

import java.util.List;

import com.model.entity.Student;

public interface StudentService {
    List<Student> getAllStudents();
    
    Student getStudentById(int rollnumber);
    
    Student addStudent(Student student);
}
