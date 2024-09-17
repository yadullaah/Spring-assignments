package com.model.mapping.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.dto.InstructorDto;
import com.model.entity.Course;
import com.model.entity.Instructor;
import com.model.repository.CourseRepository;
import com.model.repository.InstructorRepository;

@Service
public class InstructorServiceImpl implements InstructorService {

	@Autowired
	private InstructorRepository instructorRepo;
	
	@Autowired
	private CourseRepository courseRepo;

	@Override
	public InstructorDto addInstructor(InstructorDto instructorDto) {

		Instructor instructor = toInstructorMapper(instructorDto);
		instructor = instructorRepo.save(instructor);

		return toInstructorDtoMapper(instructor);

	}

	public InstructorDto toInstructorDtoMapper(Instructor instructor) {

		InstructorDto instructorDto = new InstructorDto();
		instructorDto.setEmail(instructor.getEmail());
		instructorDto.setInstructorId(instructor.getInstructorId());
		instructorDto.setQualification(instructor.getQualification());
		instructorDto.setName(instructor.getName());
		return instructorDto;

	}

	public Instructor toInstructorMapper(InstructorDto instructorDto) {

		Instructor instructor = new Instructor();
		instructor.setEmail(instructorDto.getEmail());
		instructor.setName(instructorDto.getName());
		instructor.setQualification(instructorDto.getQualification());
		return instructor;
	}

	@Override
	public List<InstructorDto> getAllInstructors() {

		List<Instructor> dbInstructors = instructorRepo.findAll();
		if (dbInstructors.size() == 0)
			return null;

		List<InstructorDto> instructors = new ArrayList<>();

		dbInstructors.forEach((instructor) -> {

			instructors.add(toInstructorDtoMapper(instructor));
		});

		return instructors;
	}

	@Override
	public InstructorDto getInstructorById(int instructorId) {

		Optional<Instructor> optionalInstructor = instructorRepo.findById(instructorId);
		if (optionalInstructor.isEmpty())
			return null;

		Instructor instructor = optionalInstructor.get();

		return toInstructorDtoMapper(instructor);
	}

	@Override
	public Instructor allocateCourses(int instructorId, List<Integer> courseIds) {
		Instructor dbInstructor = toInstructorMapper(getInstructorById(instructorId));
		dbInstructor.setInstructorId(instructorId);
		List<Course> dbCourses = dbInstructor.getCourses();
		if (dbCourses == null)
			dbCourses = new ArrayList<>();

		List<Course> coursesToadd = new ArrayList<>();

		courseIds.forEach((courseId) -> {
			Optional<Course> optionalCourse = courseRepo.findById(courseId);
			if (!optionalCourse.isPresent())
				throw new NullPointerException("Course does not exists");
			Course course = optionalCourse.get();
			course.setInstructor(dbInstructor);
			coursesToadd.add(course);
		});

		dbCourses.addAll(coursesToadd);
		dbInstructor.setCourses(dbCourses);

		return instructorRepo.save(dbInstructor);
	}

}
