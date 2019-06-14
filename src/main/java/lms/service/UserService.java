package lms.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DTO.UserDTO;
import lms.domain.User;
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
	
	public Iterable<UserDTO> getUsersDTO() {
		Iterable<User> c = userRepository.findAll();
		Set<UserDTO> cd = new HashSet<>();
		for(User ct: c)
			cd.add(ct.toDTO());
		return cd;
	}

	
	
	
}