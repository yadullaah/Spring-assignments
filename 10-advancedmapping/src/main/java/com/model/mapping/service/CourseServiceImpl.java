package com.model.mapping.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.model.dto.CourseDto;
import com.model.entity.Course;
import com.model.entity.Instructor;
import com.model.repository.CourseRepository;
import com.model.repository.InstructorRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseRepository courseRepo;
	@Autowired
	private InstructorRepository instructorRepo;
	
	private static final Logger logger = LoggerFactory.getLogger(CourseServiceImpl.class);

	@Override
	public CourseDto addCourse(CourseDto courseDto) {

		Course course = toCourseMapper(courseDto);
		course = courseRepo.save(course);
		
		logger.info("course added successfully: "+course.getCourseId());

		return toCourseDtoMapper(course);
	}

	public CourseDto toCourseDtoMapper(Course course) {
		CourseDto courseDto = new CourseDto();
		courseDto.setCourseId(course.getCourseId());
		courseDto.setName(course.getName());
		courseDto.setDuration(course.getDuration());
		courseDto.setFees(course.getFees());
		return courseDto;
	}

	public Course toCourseMapper(CourseDto courseDto) {
		Course course = new Course();
		course.setName(courseDto.getName());
		course.setDuration(courseDto.getDuration());
		course.setFees(courseDto.getFees());
		return course;
	}

	@Override
	public List<CourseDto> getAllCourses() {
		List<Course> courses = courseRepo.findAll();
		if (courses.size() == 0)
			return null;

		List<CourseDto> courseDtos = new ArrayList<>();

		courses.forEach((course) -> {
			courseDtos.add(toCourseDtoMapper(course));
		});

		return courseDtos;
	}

	@Override
	public CourseDto getCourseById(int courseId) {
		Course course = null;

		Optional<Course> optionalCourse = courseRepo.findById(courseId);

		if (optionalCourse.isEmpty()) {
			
			logger.error("course with id "+ courseId+" not found");
			return null;
			
		}
			

		course = optionalCourse.get();
		return toCourseDtoMapper(course);
	}

	@Override
	public CourseDto assignInstructor(int courseId, int instructorId) {

		Course dbCourse = toCourseMapper(getCourseById(courseId));
		dbCourse.setCourseId(courseId);

		Instructor instructor = instructorRepo.findById(instructorId)
				.orElseThrow(() -> new NullPointerException("Instructor doest not exist"));

		dbCourse.setInstructor(instructor);
		courseRepo.save(dbCourse);

		return toCourseDtoMapper(dbCourse);
	}
}
