package lms.controllers;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lms.domain.User;
import lms.service.LoginService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
public class LoginController {
	@Autowired 
	LoginService loginService;
	
	@PostMapping(value = "/login")
	ResponseEntity<HashMap<String, String>> login(@RequestBody User user) {
		return loginService.login(user);
	}
	
	@PostMapping(value = "/register")
	ResponseEntity<User> register(@RequestBody User user) {
		return loginService.register(user);
	}
	
	@GetMapping("/test")
	@Secured("ROLE_ADMIN")
	public ResponseEntity<String> test() {
		return new ResponseEntity<String>("Test success!", HttpStatus.OK);
	}
	
}