package lms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lms.domain.CourseTeaching;
import lms.domain.CourseType;
import lms.repository.CourseTypeRepository;

@Service
public class CourseTypeService {

	@Autowired
	CourseTypeRepository courseTypeRepository;

	public Iterable<CourseType> getAllCourseType() {
		return courseTypeRepository.findAll();
	}

	public void addCourseType(CourseType c) {
		courseTypeRepository.save(c);
	}

	public Optional<CourseType> getCourseTypeId(Long id) {
		return courseTypeRepository.findById(id);
	}

	public void removeCourseType(Long id) {
		Optional<CourseType> c = courseTypeRepository.findById(id);
		courseTypeRepository.delete(c.get());
	}
	
	public void updateCourseType(Long id, CourseType ct) {
		Optional<CourseType> CT = courseTypeRepository.findById(id);
		if (CT.isPresent()) {
			ct.setId(CT.get().getId());
			courseTypeRepository.save(ct);
		}
	}

}
