package lms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lms.domain.Country;
import lms.domain.ExamAttending;
import lms.repository.CourseAttendingRepository;

@Service
public class CourseAttendingService {

	@Autowired
	CourseAttendingRepository courseAttendingRepository;

	public List<ExamAttending> findAll() {
		return courseAttendingRepository.findAll();
	}

	public void addCourseAttending(ExamAttending c) {
		courseAttendingRepository.save(c);
	}

	public Optional<ExamAttending> getCourseAttending(Long id) {
		return courseAttendingRepository.findById(id);
	}

	public void removeCourseAttending(Long id) {
		Optional<ExamAttending> c = courseAttendingRepository.findById(id);
		courseAttendingRepository.delete(c.get());
	}

	public void updateCourseAttending(Long id, ExamAttending ca) {
		Optional<ExamAttending> CA = courseAttendingRepository.findById(id);
		if (CA.isPresent()) {
			ca.setId(CA.get().getId());
			courseAttendingRepository.save(ca);
		}
	}

}
