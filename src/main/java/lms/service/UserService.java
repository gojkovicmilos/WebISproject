package lms.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lms.domain.User;
import lms.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;

	public Optional<User> getUser(String username) {
		return userRepository.getByUsername(username);
	}

	public Optional<User> getUser(String username, String password) {
		return userRepository.getByUsernameAndPassword(username, password);
	}

	public void saveUser(User user) {
		userRepository.save(user);
	}
}