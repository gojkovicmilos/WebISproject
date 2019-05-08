package lms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lms.domain.Teacher;
import lms.repository.TeacherRepository;

@Service
public class TeacherService {

	@Autowired
	TeacherRepository teacherRepository;
	
	public List<Teacher> findAll(){
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

}
