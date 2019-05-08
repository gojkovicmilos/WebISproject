package lms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lms.domain.CourseAttending;
import lms.repository.CourseAttendingRepository;

@Service
public class CourseAttendingService {

	@Autowired
	CourseAttendingRepository courseAttendingRepository;
	
	public List<CourseAttending> findAll(){
		return courseAttendingRepository.findAll();
	}
	

	public void addCourseAttending(CourseAttending c) {
		courseAttendingRepository.save(c);
	}
	
	public Optional<CourseAttending> getCourseAttending(Long id) {
		return courseAttendingRepository.findById(id);
	}
	
	
	public void removeCourseAttending(Long id) {
		Optional<CourseAttending> c = courseAttendingRepository.findById(id);
		courseAttendingRepository.delete(c.get());
	}

}
