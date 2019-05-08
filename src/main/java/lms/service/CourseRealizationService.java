package lms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lms.domain.CourseRealization;
import lms.repository.CourseRealizationRepository;

@Service
public class CourseRealizationService {

	@Autowired
	CourseRealizationRepository courseRealizationRepository;
	
	public List<CourseRealization> findAll(){
		return courseRealizationRepository.findAll();
	}
	
	public void addCourseRealization(CourseRealization c) {
		courseRealizationRepository.save(c);
	}
	
	public Optional<CourseRealization> getCourseRealization(Long id) {
		return courseRealizationRepository.findById(id);
	}
	
	
	public void removeCourseRealization(Long id) {
		Optional<CourseRealization> c = courseRealizationRepository.findById(id);
		courseRealizationRepository.delete(c.get());
	}

}
