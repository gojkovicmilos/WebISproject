package lms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lms.domain.Faculty;
import lms.domain.Outcome;
import lms.repository.OutcomeRepository;

@Service
public class OutcomeService {

	@Autowired
	OutcomeRepository outcomeRepository;

	public List<Outcome> findAll() {
		return outcomeRepository.findAll();
	}

	public void addOutcome(Outcome o) {
		outcomeRepository.save(o);
	}

	public Optional<Outcome> getOutcome(Long id) {
		return outcomeRepository.findById(id);
	}

	public void removeOutcome(Long id) {
		Optional<Outcome> o = outcomeRepository.findById(id);
		outcomeRepository.delete(o.get());
	}

	public void updateOutcome(Long id, Outcome o) {
		Optional<Outcome> O = outcomeRepository.findById(id);
		if (O.isPresent()) {
			o.setId(O.get().getId());
			outcomeRepository.save(o);
		}
	}

}
