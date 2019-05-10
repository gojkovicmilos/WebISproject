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

import lms.domain.CourseType;
import lms.service.CourseTypeService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/coursetype")
public class CourseTypeController {

	@Autowired
	CourseTypeService courseTypeService;

	@RequestMapping()
	public ResponseEntity<Iterable<CourseType>> getCourseType() {
		return new ResponseEntity<Iterable<CourseType>>(courseTypeService.findAll(), HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<CourseType> getCourseTypeById(@PathVariable Long id) {
		Optional<CourseType> courseType = courseTypeService.getCourseType(id);
		if (courseType.isPresent()) {
			return new ResponseEntity<CourseType>(courseType.get(), HttpStatus.OK);
		}
		return new ResponseEntity<CourseType>(HttpStatus.NOT_FOUND);
	}

	@PostMapping
	public ResponseEntity<CourseType> addCourseType(@RequestBody CourseType courseType) {

		courseTypeService.addCourseType(courseType);
		return new ResponseEntity<CourseType>(courseType, HttpStatus.CREATED);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<CourseType> updateCourseType(@PathVariable Long id, @RequestBody CourseType courseType) {
		courseTypeService.updateCourseType(id, courseType);
		return new ResponseEntity<CourseType>(courseType, HttpStatus.CREATED);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<CourseType> removeCourseType(@PathVariable Long id) {
		try {
			courseTypeService.removeCourseType(id);
		} catch (Exception e) {
			return new ResponseEntity<CourseType>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<CourseType>(HttpStatus.NO_CONTENT);
	}
}
