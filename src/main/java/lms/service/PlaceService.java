package lms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lms.domain.Place;
import lms.repository.PlaceRepository;

@Service
public class PlaceService {

	@Autowired
	PlaceRepository placeRepository;
	
	public List<Place> findAll(){
		return placeRepository.findAll();
	}
	
	public void addPlace(Place p) {
		placeRepository.save(p);
	}
	
	public Optional<Place> getPlace(Long id) {
		return placeRepository.findById(id);
	}
	
	
	public void removePlace(Long id) {
		Optional<Place> p = placeRepository.findById(id);
		placeRepository.delete(p.get());
	}

}
