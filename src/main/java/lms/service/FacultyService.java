package lms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lms.domain.Country;
import lms.domain.CourseType;
import lms.domain.Faculty;
import lms.repository.FacultyRepository;

@Service
public class FacultyService {

	@Autowired
	FacultyRepository facultyRepository;

	public List<Faculty> findAll() {
		return facultyRepository.findAll();
	}

	public void addFaculty(Faculty f) {
		facultyRepository.save(f);
	}

	public Optional<Faculty> getFaculty(Long id) {
		return facultyRepository.findById(id);
	}
	
//	public Iterable<Faculty> getFaculty() {
//		return facultyRepository.findAll();
//	}


	public void removeFaculty(Long id) {
		Optional<Faculty> f = facultyRepository.findById(id);
		facultyRepository.delete(f.get());
	}

	public void updateFaculty(Long id, Faculty f) {
		Optional<Faculty> F = facultyRepository.findById(id);
		if (F.isPresent()) {
			f.setId(F.get().getId());
			facultyRepository.save(f);
		}
	}

	public Optional<Faculty> getFacultyById(Long id) {
		// TODO Auto-generated method stub
		return facultyRepository.findById(id);
	}

}
