package com.model.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.model.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

//		List<Student> findByName(String name);

	Student findByName(String name);

	Page<Student> findByName(String name, Pageable pageable);
}
