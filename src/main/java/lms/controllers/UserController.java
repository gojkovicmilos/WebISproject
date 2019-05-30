package lms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lms.domain.User;
import lms.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired()
	UserService userService;
	
	@PostMapping
	public ResponseEntity<User> addUser(@RequestBody User user) {

		userService.saveUser(user);
		return new ResponseEntity<User>(user, HttpStatus.CREATED);
	}

}
