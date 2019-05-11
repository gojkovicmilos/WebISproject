package lms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
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
import java.util.Optional;
import org.springframework.http.HttpStatus;
import lms.domain.Student;
import lms.service.StudentService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@GetMapping
	public ResponseEntity<Iterable<Student>> getAllStudent() {
		return new ResponseEntity<Iterable<Student>>(studentService.getStudents(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
		Optional<Student> student = studentService.getStudentById(id);
		if(student.isPresent()) {
			return new ResponseEntity<Student>(student.get(), HttpStatus.OK);
		}
		return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping
	public ResponseEntity<Student> addStudent(@RequestBody Student student) {
		studentService.addStudent(student);
		return new ResponseEntity<Student>(student, HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/update/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student student) {
		studentService.updateStudent(id, student);
		return new ResponseEntity<Student>(student, HttpStatus.CREATED);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Student> deleteStudent(@PathVariable Long id) {
		try {
			studentService.removeStudent(id);
			
		}
		catch(Exception e) {
			return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Student>(HttpStatus.NO_CONTENT);
		
	}
	
	@GetMapping(value = "/lastname/{lastName}")
	public ResponseEntity<Iterable<Student>> getStudentByLastName(@PathVariable String lastName) {
		Iterable<Student> s = studentService.getByLastName(lastName);
		if(!s.equals(null)) {
			return new ResponseEntity<Iterable<Student>>(s, HttpStatus.FOUND);
		}
		return new ResponseEntity<Iterable<Student>>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping(value = "/firstname/{firstName}")
	public ResponseEntity<Iterable<Student>> getStudentByFirstName(@PathVariable String firstName) {
		Iterable<Student> s = studentService.getByFirstName(firstName);
		if(!s.equals(null)) {
			return new ResponseEntity<Iterable<Student>>(s, HttpStatus.FOUND);
		}
		return new ResponseEntity<Iterable<Student>>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping(value = "/cardnumber/{cardNumber}")
	public ResponseEntity<Student> getStudentByCardNumber(@PathVariable String cardNumber) {
		Optional<Student> student = studentService.getByCardNumber(cardNumber);
		if(student.isPresent()) {
			return new ResponseEntity<Student>(student.get(), HttpStatus.FOUND);
		}
		return new ResponseEntity<Student>(HttpStatus.NO_CONTENT);
	}
	
	

	
	
}
