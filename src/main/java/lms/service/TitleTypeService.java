package lms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lms.domain.Teacher;
import lms.domain.TitleType;
import lms.repository.TitleTypeRepository;

@Service
public class TitleTypeService {

	@Autowired
	TitleTypeRepository titleTypeRepository;

	public List<TitleType> findAll() {
		return titleTypeRepository.findAll();
	}

	public void addTitleType(TitleType t) {
		titleTypeRepository.save(t);
	}

	public Optional<TitleType> getTitleType(Long id) {
		return titleTypeRepository.findById(id);
	}

	public void removeTitleType(Long id) {
		Optional<TitleType> t = titleTypeRepository.findById(id);
		titleTypeRepository.delete(t.get());
	}
	
	public void updateTitleType(Long id, TitleType tt) {
		Optional<TitleType> TT = titleTypeRepository.findById(id);
		if (TT.isPresent()) {
			tt.setId(TT.get().getId());
			titleTypeRepository.save(tt);
		}
	}

}
