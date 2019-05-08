package lms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lms.domain.StudyField;
import lms.repository.StudyFieldRepository;

@Service
public class StudyFieldService {

	@Autowired
	StudyFieldRepository studyFieldRepository;
	
	public List<StudyField> findAll(){
		return studyFieldRepository.findAll();
	}
	
	public void addStudyField(StudyField s) {
		studyFieldRepository.save(s);
	}
	
	public Optional<StudyField> getStudyField(Long id) {
		return studyFieldRepository.findById(id);
	}
	
	
	public void removeStudyField(Long id) {
		Optional<StudyField> s = studyFieldRepository.findById(id);
		studyFieldRepository.delete(s.get());
	}

}
