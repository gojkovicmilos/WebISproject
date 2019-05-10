package lms.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lms.domain.Center;
import lms.repository.CenterRepository;

@Service
public class CenterService {
	
	@Autowired
	CenterRepository centerRepository;
	
	public Iterable<Center> getAllCenter() {
		return centerRepository.findAll();
	}
	
	public void addCenter(Center c) {
		centerRepository.save(c);
	}

	public Optional<Center> getCenterId(Long id) {
		return centerRepository.findById(id);
	}

	public void removeCenter(Long id) {
		Optional<Center> c = centerRepository.findById(id);
		centerRepository.delete(c.get());
	}

	public void updateCenter(Long id, Center c) {
		Optional<Center> cou = centerRepository.findById(id);
		if (cou.isPresent()) {
			c.setId(cou.get().getId());
			centerRepository.save(c);
		}
	}
}
