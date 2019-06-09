package lms.service;

import java.util.HashSet;
import java.util.Optional;

import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lms.domain.User;
import lms.domain.UserPermission;
import lms.repository.PermissionRepository;
import lms.repository.UserRepository;

@Service
public class UserService{
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PermissionRepository permissionRepository;
	

	public Optional<User> getUser(String username) {
		return userRepository.getByUsername(username);
	}

	public Optional<User> getUser(String username, String password) {
		return userRepository.getByUsernameAndPassword(username, password);
	}

	public void saveUser(User user) {
		userRepository.save(user);
	}
	
	public Iterable<User> getUsers() {
		return userRepository.findAll();
	}

	
	
	
}