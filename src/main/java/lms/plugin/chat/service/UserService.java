package lms.plugin.chat.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lms.domain.Student;
import lms.plugin.chat.model.User;
import lms.plugin.chat.repository.UserRepository;


@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	public UserService() {}
	
	public List<lms.plugin.chat.model.User> getAllUser() {
		return userRepository.findAll();
	}

	public void addUser(User o) {
		userRepository.save(o);
	}

	public Optional<lms.plugin.chat.model.User> getUserId(Long id) {
		return userRepository.findById(id);
	}
	
	public User getByUsername(String username) {
		return userRepository.findByUserName(username);
	}
	



}