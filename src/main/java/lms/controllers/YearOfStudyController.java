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

import lms.domain.YearOfStudy;
import lms.service.YearOfStudyService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/yearofstudy")
public class YearOfStudyController {

	@Autowired
	YearOfStudyService yearOfStudyService;

	@RequestMapping()
	public ResponseEntity<Iterable<YearOfStudy>> getYearOfStudy() {
		return new ResponseEntity<Iterable<YearOfStudy>>(yearOfStudyService.findAll(), HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<YearOfStudy> getYearOfStudyById(@PathVariable Long id) {
		Optional<YearOfStudy> yearOfStudy = yearOfStudyService.getYearOfStudy(id);
		if (yearOfStudy.isPresent()) {
			return new ResponseEntity<YearOfStudy>(yearOfStudy.get(), HttpStatus.OK);
		}
		return new ResponseEntity<YearOfStudy>(HttpStatus.NOT_FOUND);
	}

	@PostMapping
	public ResponseEntity<YearOfStudy> addYearOfStudy(@RequestBody YearOfStudy yearOfStudy) {

		yearOfStudyService.addYearOfStudy(yearOfStudy);
		return new ResponseEntity<YearOfStudy>(yearOfStudy, HttpStatus.CREATED);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<YearOfStudy> updateYearOfStudy(@PathVariable Long id, @RequestBody YearOfStudy yearOfStudy) {
		yearOfStudyService.updateYearOfStudy(id, yearOfStudy);
		return new ResponseEntity<YearOfStudy>(yearOfStudy, HttpStatus.CREATED);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<YearOfStudy> removeYearOfStudy(@PathVariable Long id) {
		try {
			yearOfStudyService.removeYearOfStudy(id);
		} catch (Exception e) {
			return new ResponseEntity<YearOfStudy>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<YearOfStudy>(HttpStatus.NO_CONTENT);
	}
}
