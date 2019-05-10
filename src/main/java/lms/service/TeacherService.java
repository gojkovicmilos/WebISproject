package lms.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lms.domain.Course;
import lms.domain.CourseTeaching;
import lms.domain.Teacher;
import lms.repository.TeacherRepository;

@Service
public class TeacherService {

	@Autowired
	TeacherRepository teacherRepository;

	public List<Teacher> findAll() {
		return teacherRepository.findAll();
	}

	public void addTeacher(Teacher t) {
		teacherRepository.save(t);
	}

	public Optional<Teacher> getTeacher(Long id) {
		return teacherRepository.findById(id);
	}

	public void removeTeacher(Long id) {
		Optional<Teacher> t = teacherRepository.findById(id);
		teacherRepository.delete(t.get());
	}

	public void updateTeacher(Long id, Teacher t) {
		Optional<Teacher> T = teacherRepository.findById(id);
		if (T.isPresent()) {
			t.setId(T.get().getId());
			teacherRepository.save(t);
		}
	}

	public Set<Course> getAllCourses(Teacher teacher) {

		Set<Course> ret = new HashSet<>();
		for (CourseTeaching courseTeaching : teacher.getCourseTeachings())
			ret.add(courseTeaching.getCourseRealization().getCourse());

		return ret;

	}

}
