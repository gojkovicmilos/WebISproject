package lms.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lms.domain.StudyProgram;
import lms.repository.StudyProgramRepository;

@Service
public class StudyProgramService {

	@Autowired
	StudyProgramRepository studyProgramRepository;

	public Iterable<StudyProgram> getAllStidyProgram() {
		return studyProgramRepository.findAll();
	}

	public void addStudyProgram(StudyProgram s) {
		studyProgramRepository.save(s);
	}

	public Optional<StudyProgram> getStudyProgramId(Long id) {
		return studyProgramRepository.findById(id);
	}

	public void removeStudyProgram(Long id) {
		Optional<StudyProgram> s = studyProgramRepository.findById(id);
		studyProgramRepository.delete(s.get());
	}
	
	public void updateStudyProgram(Long id, StudyProgram sp) {
		Optional<StudyProgram> SP = studyProgramRepository.findById(id);
		if (SP.isPresent()) {
			sp.setId(SP.get().getId());
			studyProgramRepository.save(sp);
		}
	}


}
