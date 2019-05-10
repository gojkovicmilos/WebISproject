package lms.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lms.domain.Country;
import lms.repository.CountryRepository;

@Service
public class CountryService {

	@Autowired
	CountryRepository countryRepository;
	
	public CountryService() {}

	public Iterable<Country> getAllCountry() {
		return countryRepository.findAll();
	}
	
	public void addCountry(Country c) {
		countryRepository.save(c);
	}

	public Optional<Country> getCountryId(Long id) {
		return countryRepository.findById(id);
	}

	public void removeCountry(Long id) {
		Optional<Country> c = countryRepository.findById(id);
		countryRepository.delete(c.get());
	}

	public void updateCountry(Long id, Country c) {
		Optional<Country> cou = countryRepository.findById(id);
		if (cou.isPresent()) {
			c.setId(cou.get().getId());
			countryRepository.save(c);
		}
	}

}
