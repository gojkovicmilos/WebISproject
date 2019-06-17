package lms.controllers;

import java.security.NoSuchAlgorithmException;
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

import com.fasterxml.jackson.annotation.JsonView;

import DTO.CourseDTO;
import DTO.CourseGradeDTO;
import DTO.EvaluationPointsDTO;
import DTO.StudentDTO;
import lms.domain.Course;
import lms.domain.Student;
import lms.service.CourseService;
import lms.service.StudentService;
import lms.utils.View.HideOptionalProperties;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@Autowired
	CourseService courseService;
	
	@GetMapping
	public ResponseEntity<Iterable<StudentDTO>> getAllStudent() {
		return new ResponseEntity<Iterable<StudentDTO>>(studentService.getStudents(), HttpStatus.OK);
	}
	

	@GetMapping(value = "/{id}")
	public ResponseEntity<StudentDTO> getStudentById(@PathVariable Long id) {
		Optional<Student> student = studentService.getStudentById(id);
		if(student.isPresent()) {
			return new ResponseEntity<StudentDTO>(student.get().toDTO(), HttpStatus.OK);
		}
		return new ResponseEntity<StudentDTO>(HttpStatus.NOT_FOUND);
	}

	@GetMapping(value = "/{id}/findallcurrentcourses")
	public ResponseEntity<Iterable<CourseDTO>> findAllCurrentCourses(@PathVariable Long id) {
		Optional<Student> student = studentService.getStudentById(id);
		if(student.isPresent()) {
			return new ResponseEntity<Iterable<CourseDTO>>(studentService.findAllCurrentCourses(student.get()), HttpStatus.OK);
		}
		return new ResponseEntity<Iterable<CourseDTO>>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping(value = "/{id}/findallfinishedcourses")
	public ResponseEntity<Iterable<CourseGradeDTO>> findAllFinishedCourses(@PathVariable Long id) {
		Optional<Student> student = studentService.getStudentById(id);
		if(student.isPresent()) {
			return new ResponseEntity<Iterable<CourseGradeDTO>>(studentService.findAllFinishedCourses(student.get()), HttpStatus.OK);
		}
		return new ResponseEntity<Iterable<CourseGradeDTO>>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping(value = "/{ids}/{idp}/findallevaluations")
	public ResponseEntity<Iterable<EvaluationPointsDTO>> findAllEvaluations(@PathVariable Long ids, @PathVariable Long idp) {
		Optional<Student> student = studentService.getStudentById(ids);
		Optional<Course> course = courseService.getCourseId(idp);
		if(student.isPresent() && course.isPresent() ) {
			return new ResponseEntity<Iterable<EvaluationPointsDTO>>(studentService.findAllEvaluations(course.get(), student.get()), HttpStatus.OK);
		}
		return new ResponseEntity<Iterable<EvaluationPointsDTO>>(HttpStatus.NOT_FOUND);
	}
	
	
	
	@PostMapping
	@Secured("ROLE_ADMIN")
	public ResponseEntity<Student> addStudent(@RequestBody Student student) throws NoSuchAlgorithmException{
		studentService.addStudent(student);
		return new ResponseEntity<Student>(student, HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/update/{id}")
	@Secured("ROLE_ADMIN")
	public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student student) {
		
		Optional<Student> sorg = studentService.getStudent(id);
		
		if(sorg.get().getCardNumber()!= student.getCardNumber())
			return new ResponseEntity<Student>(HttpStatus.BAD_REQUEST);
		
		studentService.updateStudent(id, student);
		return new ResponseEntity<Student>(student, HttpStatus.CREATED);
	}
	
	@DeleteMapping(value = "/{id}")
	@Secured("ROLE_ADMIN")
	public ResponseEntity<Student> deleteStudent(@PathVariable Long id) {
		try {
			studentService.removeStudent(id);
			
		}
		catch(Exception e) {
			return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Student>(HttpStatus.NO_CONTENT);
		
	}
	
	@JsonView(HideOptionalProperties.class)
	@GetMapping(value = "/lastname/{lastName}")
	public ResponseEntity<Iterable<Student>> getStudentByLastName(@PathVariable String lastName) {
		return new ResponseEntity<Iterable<Student>>(studentService.getByLastName(lastName), HttpStatus.OK);
	}
	
	@JsonView(HideOptionalProperties.class)
	@GetMapping(value = "/firstname/{firstName}")
	public ResponseEntity<Iterable<Student>> getStudentByFirstName(@PathVariable String firstName) {
		return new ResponseEntity<Iterable<Student>>(studentService.getByFirstName(firstName), HttpStatus.OK);
	}
	
	@JsonView(HideOptionalProperties.class)
	@GetMapping(value = "/cardnumber/{cardNumber}")
	public ResponseEntity<Student> getStudentByCardNumber(@PathVariable String cardNumber) {
		Optional<Student> student = studentService.getByCardNumber(cardNumber);
		if(student.isPresent()) {
			return new ResponseEntity<Student>(student.get(), HttpStatus.FOUND);
		}
		return new ResponseEntity<Student>(HttpStatus.NO_CONTENT);
	}
	
	
	
	

	
	
}
