package lms.service;

import java.util.HashMap;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import lms.domain.User;
import lms.domain.UserPermission;
import lms.repository.PermissionRepository;
import lms.repository.UserRepository;
import lms.utils.TokenUtils;

@Service
public class LoginService {
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
	
	
	public ResponseEntity<HashMap<String, String>> login(User user) {
		try {
			UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(user.getUsername(),
					user.getPassword());

			Authentication authentication = authenticationManager.authenticate(token);
			SecurityContextHolder.getContext().setAuthentication(authentication);

			UserDetails details = userDetailsService.loadUserByUsername(user.getUsername());
			String userToken = tokenUtils.generateToken(details);

			HashMap<String, String> data = new HashMap<String, String>();
			data.put("token", userToken);
			
			String role = userService.getUser(user.getUsername()).get().getRole();
			
			data.put("role", role);

			return new ResponseEntity<HashMap<String, String>>(data, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<HashMap<String, String>>(HttpStatus.UNAUTHORIZED);
		}
	}

	public ResponseEntity<User> register(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		addPermission(user);
		
		

		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	public ResponseEntity<User> registerStudent(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		addPermission(user);
		
		

		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	
	public void addPermission(User user) {
		user = userRepository.save(user);
		user.setUserPermissions(new HashSet<UserPermission>());
		user.getUserPermissions().add(new UserPermission(null, user, permissionRepository.getByTitle(user.getRole()).get()));
		userRepository.save(user);
	}

	

}
