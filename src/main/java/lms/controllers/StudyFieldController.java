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

import lms.domain.StudyField;
import lms.service.StudyFieldService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/studyfield")
public class StudyFieldController {

	@Autowired
	StudyFieldService studyFieldService;

	@RequestMapping()
	public ResponseEntity<Iterable<StudyField>> getAllStudyField() {
		return new ResponseEntity<Iterable<StudyField>>(studyFieldService.getAllStudyField(), HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<StudyField> getStudyFieldById(@PathVariable Long id) {
		Optional<StudyField> studyField = studyFieldService.getStudyFieldId(id);
		if (studyField.isPresent()) {
			return new ResponseEntity<StudyField>(studyField.get(), HttpStatus.OK);
		}
		return new ResponseEntity<StudyField>(HttpStatus.NOT_FOUND);
	}

	@PostMapping
	public ResponseEntity<StudyField> addStudyField(@RequestBody StudyField studyField) {

		studyFieldService.addStudyField(studyField);
		return new ResponseEntity<StudyField>(studyField, HttpStatus.CREATED);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<StudyField> updateStudyField(@PathVariable Long id, @RequestBody StudyField studyField) {
		studyFieldService.updateStudyField(id, studyField);
		return new ResponseEntity<StudyField>(studyField, HttpStatus.CREATED);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<StudyField> removeStudyField(@PathVariable Long id) {
		try {
			studyFieldService.removeStudyField(id);
		} catch (Exception e) {
			return new ResponseEntity<StudyField>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<StudyField>(HttpStatus.NO_CONTENT);
	}
}
