package lms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lms.domain.University;
import lms.domain.YearOfStudy;
import lms.repository.YearOfStudyRepository;

@Service
public class YearOfStudyService {

	@Autowired
	YearOfStudyRepository yearOfStudyRepository;

	public List<YearOfStudy> findAll() {
		return yearOfStudyRepository.findAll();
	}

	public void addYearOfStudy(YearOfStudy y) {
		yearOfStudyRepository.save(y);
	}

	public Optional<YearOfStudy> getYearOfStudy(Long id) {
		return yearOfStudyRepository.findById(id);
	}

	public void removeYearOfStudy(Long id) {
		Optional<YearOfStudy> y = yearOfStudyRepository.findById(id);
		yearOfStudyRepository.delete(y.get());
	}
	
	public void updateYearOfStudy(Long id, YearOfStudy yos) {
		Optional<YearOfStudy> YOS = yearOfStudyRepository.findById(id);
		if (YOS.isPresent()) {
			yos.setId(YOS.get().getId());
			yearOfStudyRepository.save(yos);
		}
	}

}
