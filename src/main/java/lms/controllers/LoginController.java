package lms.controllers;

import java.util.HashMap;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lms.domain.User;
import lms.domain.UserPermission;
import lms.repository.PermissionRepository;
import lms.repository.UserRepository;
import lms.service.UserService;
import lms.utils.TokenUtils;


@RestController
public class LoginController {
	@Autowired
	UserService userService;

	@Autowired
	UserRepository userRepository;

	@Autowired
	PermissionRepository permissionRepository;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private TokenUtils tokenUtils;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@PostMapping(path = "/login")
	public ResponseEntity<HashMap<String, String>> login(@RequestBody User user) {
		try {
			UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(user.getUsername(),
					user.getPassword());

			Authentication authentication = authenticationManager.authenticate(token);
			SecurityContextHolder.getContext().setAuthentication(authentication);

			UserDetails details = userDetailsService.loadUserByUsername(user.getUsername());
			String userToken = tokenUtils.generateToken(details);

			HashMap<String, String> data = new HashMap<String, String>();
			data.put("token", userToken);

			return new ResponseEntity<HashMap<String, String>>(data, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<HashMap<String, String>>(HttpStatus.UNAUTHORIZED);
		}
	}

	@PostMapping(path = "/register")
	public ResponseEntity<User> register(@RequestBody User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));

		user = userRepository.save(user);
		user.setUserPermissions(new HashSet<UserPermission>());
		user.getUserPermissions().add(new UserPermission(null, user, permissionRepository.findById(1l).get()));
		//userRepository.save(user);

		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@RequestMapping("/test")
	@Secured("ROLE_ADMIN")
	public ResponseEntity<String> test() {
		return new ResponseEntity<String>("Test success!", HttpStatus.OK);
	}
}