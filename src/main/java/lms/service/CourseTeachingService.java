package lms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lms.domain.Course;
import lms.domain.CourseTeaching;
import lms.repository.CourseTeachingRepository;

@Service
public class CourseTeachingService {

	@Autowired
	CourseTeachingRepository courseTeachingRepository;

	public List<CourseTeaching> findAll() {
		return courseTeachingRepository.findAll();
	}

	public void addCourseTeaching(CourseTeaching c) {
		courseTeachingRepository.save(c);
	}

	public Optional<CourseTeaching> getCourseTeaching(Long id) {
		return courseTeachingRepository.findById(id);
	}

	public void removeCourseTeaching(Long id) {
		Optional<CourseTeaching> c = courseTeachingRepository.findById(id);
		courseTeachingRepository.delete(c.get());
	}

	public void updateCourseTeaching(Long id, CourseTeaching ct) {
		Optional<CourseTeaching> CT = courseTeachingRepository.findById(id);
		if (CT.isPresent()) {
			ct.setId(CT.get().getId());
			courseTeachingRepository.save(ct);
		}
	}

}
