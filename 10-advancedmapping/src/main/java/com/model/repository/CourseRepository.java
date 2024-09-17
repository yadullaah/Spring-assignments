	package com.model.repository;
	
	import org.springframework.data.jpa.repository.JpaRepository;
	
	import com.model.entity.Course;
	
	public interface CourseRepository extends JpaRepository<Course, Integer> {
	
	}
