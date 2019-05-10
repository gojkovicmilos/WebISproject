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

import lms.domain.University;
import lms.service.UniversityService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/university")
public class UniversityController {

	@Autowired
	UniversityService universityService;

	@RequestMapping()
	public ResponseEntity<Iterable<University>> getAllUniversity() {
		return new ResponseEntity<Iterable<University>>(universityService.getAllUniversity(), HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<University> getUniversityById(@PathVariable Long id) {
		Optional<University> university = universityService.getUniversityId(id);
		if (university.isPresent()) {
			return new ResponseEntity<University>(university.get(), HttpStatus.OK);
		}
		return new ResponseEntity<University>(HttpStatus.NOT_FOUND);
	}

	@PostMapping
	public ResponseEntity<University> addUniversity(@RequestBody University university) {

		universityService.addUniversity(university);
		return new ResponseEntity<University>(university, HttpStatus.CREATED);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<University> updateUniversity(@PathVariable Long id, @RequestBody University university) {
		universityService.updateUniversity(id, university);
		return new ResponseEntity<University>(university, HttpStatus.CREATED);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<University> removeUniversity(@PathVariable Long id) {
		try {
			universityService.removeUniversity(id);
		} catch (Exception e) {
			return new ResponseEntity<University>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<University>(HttpStatus.NO_CONTENT);
	}
}
