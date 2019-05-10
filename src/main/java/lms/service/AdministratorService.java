package lms.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lms.domain.Administrator;
import lms.repository.AdministratorRepository;

@Service
public class AdministratorService {

	@Autowired
	AdministratorRepository administratorRepository;

	public Iterable<Administrator> getAllAdmin() {
		return administratorRepository.findAll();
	}

	public void addAdministrator(Administrator a) {
		administratorRepository.save(a);
	}

	public Optional<Administrator> getAdminId(Long id) {
		return administratorRepository.findById(id);
	}

	public void removeAdministrator(Long id) {
		Optional<Administrator> a = administratorRepository.findById(id);
		administratorRepository.delete(a.get());
	}

	public void updateAdministrator(Long id, Administrator a) {
		Optional<Administrator> add = administratorRepository.findById(id);
		if (add.isPresent()) {
			a.setId(add.get().getId());
			administratorRepository.save(a);
		}
	}

}
