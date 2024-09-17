package com.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
