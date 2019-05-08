package lms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lms.domain.StudyProgram;
import lms.repository.StudyProgramRepository;

@Service
public class StudyProgramService {

	@Autowired
	StudyProgramRepository studyProgramRepository;
	
	public List<StudyProgram> findAll(){
		return studyProgramRepository.findAll();
	}
	
	public void addStudyProgram(StudyProgram s) {
		studyProgramRepository.save(s);
	}
	
	public Optional<StudyProgram> getStudyProgram(Long id) {
		return studyProgramRepository.findById(id);
	}
	
	
	public void removeStudyProgram(Long id) {
		Optional<StudyProgram> s = studyProgramRepository.findById(id);
		studyProgramRepository.delete(s.get());
	}

}
