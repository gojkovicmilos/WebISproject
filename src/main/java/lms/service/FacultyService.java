package lms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lms.domain.Faculty;
import lms.repository.FacultyRepository;

@Service
public class FacultyService {

	@Autowired
	FacultyRepository facultyRepository;
	
	public List<Faculty> findAll(){
		return facultyRepository.findAll();
	}
	
	public void addFaculty(Faculty f) {
		facultyRepository.save(f);
	}
	
	public Optional<Faculty> getFaculty(Long id) {
		return facultyRepository.findById(id);
	}
	
	
	public void removeFaculty(Long id) {
		Optional<Faculty> f = facultyRepository.findById(id);
		facultyRepository.delete(f.get());
	}


}
