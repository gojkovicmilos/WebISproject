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

import lms.domain.Course;
import lms.service.CourseService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/course")
public class CourseController {

	@Autowired
	CourseService courseService;

	@RequestMapping()
	public ResponseEntity<Iterable<Course>> getCourse() {
		return new ResponseEntity<Iterable<Course>>(courseService.findAll(), HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Course> getCourseById(@PathVariable Long id) {
		Optional<Course> course = courseService.getCourse(id);
		if (course.isPresent()) {
			return new ResponseEntity<Course>(course.get(), HttpStatus.OK);
		}
		return new ResponseEntity<Course>(HttpStatus.NOT_FOUND);
	}

	@PostMapping
	public ResponseEntity<Course> addCourse(@RequestBody Course course) {

		courseService.addCourse(course);
		return new ResponseEntity<Course>(course, HttpStatus.CREATED);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Course> updateCourse(@PathVariable Long id, @RequestBody Course course) {
		courseService.updateCourse(id, course);
		return new ResponseEntity<Course>(course, HttpStatus.CREATED);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Course> removeCourse(@PathVariable Long id) {
		try {
			courseService.removeCourse(id);
		} catch (Exception e) {
			return new ResponseEntity<Course>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Course>(HttpStatus.NO_CONTENT);
	}
}
