package com.example.demo.service;

import com.example.demo.model.UserRequest;
import com.example.demo.model.UserResponse;

public interface UserService {

	public UserResponse getUsers(String email);

	public UserResponse userRegister(UserRequest userRequest);

	public UserResponse userLogin(UserRequest userRequest) throws Exception;

}
