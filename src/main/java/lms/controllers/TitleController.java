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

import lms.domain.Title;
import lms.service.TitleService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/title")
public class TitleController {

	@Autowired
	TitleService titleService;

	@RequestMapping()
	public ResponseEntity<Iterable<Title>> getTitle() {
		return new ResponseEntity<Iterable<Title>>(titleService.getTitle(), HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Title> getTitleById(@PathVariable Long id) {
		Optional<Title> title = titleService.getTitleById(id);
		if (title.isPresent()) {
			return new ResponseEntity<Title>(title.get(), HttpStatus.OK);
		}
		return new ResponseEntity<Title>(HttpStatus.NOT_FOUND);
	}

	@PostMapping
	public ResponseEntity<Title> addTitle(@RequestBody Title title) {

		titleService.addTitle(title);
		return new ResponseEntity<Title>(title, HttpStatus.CREATED);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Title> updateTitle(@PathVariable Long id, @RequestBody Title title) {
		titleService.updateTitle(id, title);
		return new ResponseEntity<Title>(title, HttpStatus.CREATED);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Title> removeTitle(@PathVariable Long id) {
		try {
			titleService.removeTitle(id);
		} catch (Exception e) {
			return new ResponseEntity<Title>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Title>(HttpStatus.NO_CONTENT);
	}
}
