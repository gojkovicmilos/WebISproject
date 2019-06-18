package lms.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DTO.TeacherDTO;
import lms.domain.Course;
import lms.domain.CourseTeaching;
import lms.domain.Teacher;
import lms.domain.User;
import lms.repository.TeacherRepository;
import lms.repository.UserRepository;

@Service
public class TeacherService {

	@Autowired
	TeacherRepository teacherRepository;
	
	@Autowired
	UserService userService;

	public TeacherService() {}
	
	public Iterable<TeacherDTO> getAllTeacher() {
		Iterable<Teacher> ts = teacherRepository.findAll();
		Set<TeacherDTO> ret = new HashSet<>();

		for(Teacher t: ts)
			ret.add(t.toDTO());
		
		return ret;
	}

	public void addTeacher(Teacher t) {
		teacherRepository.save(t);
	}

	public Optional<Teacher> getTeacherId(Long id) {
		return teacherRepository.findById(id);
	}

	public void removeTeacher(Long id) {
		Optional<Teacher> t = teacherRepository.findById(id);
		teacherRepository.delete(t.get());
	}
	
	public void removeTeacherSoft(Long id) {
		Optional<Teacher> t = teacherRepository.findById(id);
		if(t.isPresent()) {
			t.get().setDeleted(true);
			teacherRepository.save(t.get());
			Optional<User> u = userService.getUser(t.get().getUser().getUsername());
			if(u.isPresent()) {
				userService.removeUserSoft(u.get().getId());
			}
		}
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
	
	public Iterable<Teacher> getByLastName(String lastName) {
		return teacherRepository.findByLastName(lastName);
	}
	
	public Iterable<Teacher> getByFirstName(String firstName) {
		return teacherRepository.findTeacherByFirstName(firstName);
	}
	
	public Optional<Teacher> getByPersonalIdentificationNumber(String personalIdentificationNumber) {
		return teacherRepository.findByPersonalIdentificationNumber(personalIdentificationNumber);
	}

}
