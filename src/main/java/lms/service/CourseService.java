package lms.service;

import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lms.domain.Course;
import lms.repository.CourseRepository;

@Service
public class CourseService {

	public CourseService() {}
	
	@Autowired
	CourseRepository courseRepository;

	public Iterable<Course> getAllCourse() {
		return courseRepository.findAll();
	}

	public void addCourse(Course c) {
		courseRepository.save(c);
	}

	public Optional<Course> getCourseId(Long id) {
		return courseRepository.findById(id);
	}

	public void removeCourse(Long id) {
		Optional<Course> c = courseRepository.findById(id);
		courseRepository.delete(c.get());
	}

	public void updateCourse(Long id, Course c) {
		Optional<Course> C = courseRepository.findById(id);
		if (C.isPresent()) {
			c.setId(C.get().getId());
			courseRepository.save(c);
		}
	}

	public Iterable<Course> getCourseByTitle(String title) {
		return courseRepository.findByTitle(title);
	}

}
