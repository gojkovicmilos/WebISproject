package lms.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lms.domain.Administrator;
import lms.service.AdministratorService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/admin")
public class AdministratorController {

	@Autowired
	AdministratorService administratorService;

	@RequestMapping()
	public ResponseEntity<Iterable<Administrator>> getAllAdmin() {
		return new ResponseEntity<Iterable<Administrator>>(administratorService.getAllAdmin(), HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Administrator> getAdministrator(@PathVariable Long id) {
		Optional<Administrator> faculty = administratorService.getAdminId(id);
		if (faculty.isPresent()) {
			return new ResponseEntity<Administrator>(faculty.get(), HttpStatus.OK);
		}
		return new ResponseEntity<Administrator>(HttpStatus.NOT_FOUND);
	}

	@PostMapping
	@Secured("ROLE_ADMIN")
	public ResponseEntity<Administrator> addAdministrator(@RequestBody Administrator faculty) {

		administratorService.addAdministrator(faculty);
		return new ResponseEntity<Administrator>(faculty, HttpStatus.CREATED);
	}

	@PutMapping(value = "/{id}")
	@Secured("ROLE_ADMIN")
	public ResponseEntity<Administrator> updateCountry(@PathVariable Long id, @RequestBody Administrator faculty) {
		administratorService.updateAdministrator(id, faculty);
		return new ResponseEntity<Administrator>(faculty, HttpStatus.CREATED);
	}

	@DeleteMapping(value = "/{id}")
	@Secured("ROLE_ADMIN")
	public ResponseEntity<Administrator> removeAdministrator(@PathVariable Long id) {
		try {
			administratorService.removeAdministrator(id);
		} catch (Exception e) {
			return new ResponseEntity<Administrator>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Administrator>(HttpStatus.NO_CONTENT);
	}

}