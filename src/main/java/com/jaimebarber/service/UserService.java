package com.jaimebarber.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaimebarber.entity.User;
import com.jaimebarber.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	public User save(User newUser) {
		try {
			if (userRepository.findOneByEmail(newUser.getEmail()).isPresent()) {
				return null;
			}else {
				return userRepository.save(newUser);
			}
		} catch (Exception e) {
			throw e;
		}
	}

	public User getUserById(Long id) {
		Optional<User> currentUser = userRepository.findById(id);
		if (currentUser.isPresent()) {
			return currentUser.get();
		} else {
			return null;
		}
	}

	public User getUserByEmail(String email) {
		Optional<User> currentUser = userRepository.findOneByEmail(email);
		if (currentUser.isPresent()) {
			return currentUser.get();
		} else {
			return null;
		}
	}

	public User loginUser(String email, String password) {
		Optional<User> userOptional = userRepository.findOneByEmail(email);
		if (userOptional.isPresent()) {
			User user = userOptional.get();

			if (password == user.getPassword()) {
				return user;
			}
		}
		return null;
	}

}
