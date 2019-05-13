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

import lms.domain.Teacher;
import lms.service.TeacherService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/teacher")
public class TeacherController {

	@Autowired
	TeacherService teacherService;

	@RequestMapping()
	public ResponseEntity<Iterable<Teacher>> getAllTeacher() {
		return new ResponseEntity<Iterable<Teacher>>(teacherService.getAllTeacher(), HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Teacher> getTeacherById(@PathVariable Long id) {
		Optional<Teacher> teacher = teacherService.getTeacherId(id);
		if (teacher.isPresent()) {
			return new ResponseEntity<Teacher>(teacher.get(), HttpStatus.OK);
		}
		return new ResponseEntity<Teacher>(HttpStatus.NOT_FOUND);
	}

	@PostMapping
	public ResponseEntity<Teacher> addTeacher(@RequestBody Teacher teacher) {

		teacherService.addTeacher(teacher);
		return new ResponseEntity<Teacher>(teacher, HttpStatus.CREATED);
	}

	@PutMapping(value = "/update/{id}")
	public ResponseEntity<Teacher> updateTeacher(@PathVariable Long id, @RequestBody Teacher teacher) {
		teacherService.updateTeacher(id, teacher);
		return new ResponseEntity<Teacher>(teacher, HttpStatus.CREATED);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Teacher> removeTeacher(@PathVariable Long id) {
		try {
			teacherService.removeTeacher(id);
		} catch (Exception e) {
			return new ResponseEntity<Teacher>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Teacher>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping(value = "/firstname/{firstName}")
	public ResponseEntity<Iterable<Teacher>> getByFirstName(@PathVariable String firstName) {
		return new ResponseEntity<Iterable<Teacher>>(teacherService.getByFirstName(firstName), HttpStatus.OK);
	}
	
	@GetMapping(value = "/lastname/{lastName}")
	public ResponseEntity<Iterable<Teacher>> getByLastName(@PathVariable String lastName) {
		return new ResponseEntity<Iterable<Teacher>>(teacherService.getByLastName(lastName), HttpStatus.OK);
	}
	
	@GetMapping(value = "/personaidentificationnumber/{personalIdentificationNumber}")
	public ResponseEntity<Teacher> getByPersonalIdentificationNumber(@PathVariable String personalIdentificationNumber) {
		Optional<Teacher> teacher = teacherService.getByPersonalIdentificationNumber(personalIdentificationNumber);
		if(teacher.isPresent()) {
			return new ResponseEntity<Teacher>(teacher.get(), HttpStatus.FOUND);
		}
		return new ResponseEntity<Teacher>(HttpStatus.NO_CONTENT);
	}
	
	
}
