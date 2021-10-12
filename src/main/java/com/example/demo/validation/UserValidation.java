package com.example.demo.validation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Component
public class UserValidation {

	@Autowired
	private UserRepository userRepository;

	public User validateEmail(String email) throws Exception {
		return Optional.of(userRepository.findByUserEmail(email))
				.orElseThrow(() -> new Exception("Invalid credentials"));
	}

}
