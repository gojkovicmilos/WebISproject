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

import lms.domain.CourseTeaching;
import lms.service.CourseTeachingService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/courseteaching")
public class CourseTeachingController {

	@Autowired
	CourseTeachingService courseTeachingService;

	@RequestMapping()
	public ResponseEntity<Iterable<CourseTeaching>> getCourseTeaching() {
		return new ResponseEntity<Iterable<CourseTeaching>>(courseTeachingService.findAll(), HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<CourseTeaching> getCourseTeachingById(@PathVariable Long id) {
		Optional<CourseTeaching> courseTeaching = courseTeachingService.getCourseTeaching(id);
		if (courseTeaching.isPresent()) {
			return new ResponseEntity<CourseTeaching>(courseTeaching.get(), HttpStatus.OK);
		}
		return new ResponseEntity<CourseTeaching>(HttpStatus.NOT_FOUND);
	}

	@PostMapping
	public ResponseEntity<CourseTeaching> addCourseTeaching(@RequestBody CourseTeaching courseTeaching) {

		courseTeachingService.addCourseTeaching(courseTeaching);
		return new ResponseEntity<CourseTeaching>(courseTeaching, HttpStatus.CREATED);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<CourseTeaching> updateCourseTeaching(@PathVariable Long id, @RequestBody CourseTeaching courseTeaching) {
		courseTeachingService.updateCourseTeaching(id, courseTeaching);
		return new ResponseEntity<CourseTeaching>(courseTeaching, HttpStatus.CREATED);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<CourseTeaching> removeCourseTeaching(@PathVariable Long id) {
		try {
			courseTeachingService.removeCourseTeaching(id);
		} catch (Exception e) {
			return new ResponseEntity<CourseTeaching>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<CourseTeaching>(HttpStatus.NO_CONTENT);
	}
}
