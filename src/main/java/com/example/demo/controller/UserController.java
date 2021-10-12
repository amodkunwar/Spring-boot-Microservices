package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.UserRequest;
import com.example.demo.model.UserResponse;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/user")
//@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/{userEmail}")
	public UserResponse getUser(@PathVariable("userEmail") String userEmail) {
		return userService.getUsers(userEmail);
	}

	@PostMapping("/register")
	public UserResponse userRegister(@RequestBody UserRequest userRequest) {
		return userService.userRegister(userRequest);
	}

	@PostMapping("/login")
	public UserResponse userLogin(@RequestBody UserRequest userRequest) throws Exception {
		return userService.userLogin(userRequest);
	}

	/***
	 * User Request
	 * 
	 * { "email": "amod@gmail.com", "name": "Amod", "location": "Bangalore",
	 * "qualification": "B.tech", "percentage": "76", "mobile": "9937043734",
	 * "password": "A@876" }
	 */

}
