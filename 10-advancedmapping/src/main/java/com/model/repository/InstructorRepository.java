package com.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.entity.Instructor;

public interface InstructorRepository extends JpaRepository<Instructor, Integer> {

}
