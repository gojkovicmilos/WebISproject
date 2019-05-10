package lms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lms.service.CourseAttendingService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/courseattending")
public class CourseAttendingController {

	@Autowired
	CourseAttendingService courseAttendingService;
	
	
}
