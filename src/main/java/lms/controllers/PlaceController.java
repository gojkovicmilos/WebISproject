package lms.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lms.domain.Place;
import lms.service.PlaceService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/place")
public class PlaceController {

	@Autowired
	PlaceService placeService;

	@RequestMapping()
	public ResponseEntity<Iterable<Place>> getCountry() {
		return new ResponseEntity<Iterable<Place>>(placeService.getPlace(), HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Place> getCountryById(@PathVariable Long id) {
		Optional<Place> place = placeService.getPlaceById(id);
		if (place.isPresent()) {
			return new ResponseEntity<Place>(place.get(), HttpStatus.OK);
		}
		return new ResponseEntity<Place>(HttpStatus.NOT_FOUND);
	}

	@PostMapping
	public ResponseEntity<Place> addPlace(@RequestBody Place place) {

		placeService.addPlace(place);
		return new ResponseEntity<Place>(place, HttpStatus.CREATED);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Place> updatePlace(@PathVariable Long id, @RequestBody Place place) {
		placeService.updatePlace(id, place);
		return new ResponseEntity<Place>(place, HttpStatus.CREATED);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Place> removePlace(@PathVariable Long id) {
		try {
			placeService.removePlace(id);
		} catch (Exception e) {
			return new ResponseEntity<Place>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Place>(HttpStatus.NO_CONTENT);
	}
}
