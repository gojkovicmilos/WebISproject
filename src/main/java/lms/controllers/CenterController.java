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

import lms.domain.Center;
import lms.service.CenterService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/center")
public class CenterController {
	
	@Autowired
	CenterService centerService;
	
	@GetMapping()
	public ResponseEntity<Iterable<Center>> getCenters() {
		return new ResponseEntity<Iterable<Center>>(centerService.getAllCenter(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Center> getCenterById(@PathVariable Long id) {
		Optional<Center> center = centerService.getCenterId(id);
		if (center.isPresent()) {
			return new ResponseEntity<Center>(center.get(), HttpStatus.OK);
		}
		return new ResponseEntity<Center>(HttpStatus.NOT_FOUND);
	}

	@PostMapping
	public ResponseEntity<Center> addCenter(@RequestBody Center center) {

		centerService.addCenter(center);
		return new ResponseEntity<Center>(center, HttpStatus.CREATED);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Center> updateCenter(@PathVariable Long id, @RequestBody Center center) {
		centerService.updateCenter(id, center);
		return new ResponseEntity<Center>(center, HttpStatus.CREATED);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Center> removeCenter(@PathVariable Long id) {
		try {
			centerService.removeCenter(id);
		} catch (Exception e) {
			return new ResponseEntity<Center>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Center>(HttpStatus.NO_CONTENT);
	}

}
