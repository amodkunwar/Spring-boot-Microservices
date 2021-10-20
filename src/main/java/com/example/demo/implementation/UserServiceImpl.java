package com.example.demo.implementation;

import java.text.MessageFormat;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.amod.common.exception.ApplicationException;
import com.common.HTTPStatusCode;
import com.example.demo.entity.User;
import com.example.demo.implementation.template.GenericRestTemplate;
import com.example.demo.implementation.template.UserEducationProperties;
import com.example.demo.jms.TopicPublish;
import com.example.demo.model.UserEducationRequest;
import com.example.demo.model.UserEducationResponse;
import com.example.demo.model.UserRequest;
import com.example.demo.model.UserResponse;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import com.example.demo.validation.UserValidation;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

//	@Autowired
//	private RestTemplate restTemplate;

//	@Autowired
//	private MyFeignClinet myfeignClinet;

	@Autowired
	private GenericRestTemplate genericRestTemplate;

	@Autowired
	private UserValidation userValidation;

	@Autowired
	private UserEducationProperties userEducationProperties;

	@Autowired
	private TopicPublish topicPublish;

	@Override
	public UserResponse getUsers(String email) {
		UserResponse userResponse = null;
		Optional<User> optionalUser = userRepository.findById(email);
		ResponseEntity<UserEducationResponse> execuateExchange = genericRestTemplate.execuateExchange(optionalUser,
				userEducationProperties.getBaseUrl(), HttpMethod.GET, UserEducationResponse.class);
//		MovieResponse forObject = restTemplate.getForObject("http://MOVIE/movie/"+email, MovieResponse.class);
//		MovieResponse movieResponse = myfeignClinet.getMovie(email);
		if (null == execuateExchange) {
			throw new ApplicationException("1.0.1", HTTPStatusCode.RESPONSE_CD_BADREQUEST,
					MessageFormat.format("Unable to find move details for email {0}", email));
		}
		System.out.println(execuateExchange.getBody().getEmail());
		if (optionalUser.isPresent()) {
			userResponse = setResponse(optionalUser.get());
		}
		return userResponse;
	}

	private UserResponse setResponse(User user) {
		UserResponse userResponse = new UserResponse();
		userResponse.setUserEmail(user.getUserEmail());
		userResponse.setUserLocation(user.getUserLocation());
		userResponse.setUserMobile(user.getUserMobile());
		userResponse.setUserName(user.getUserName());
		userResponse.setUserPassword(user.getUserPassword());
		userResponse.setUserPercentage(user.getUserPercentage());
		userResponse.setUserQualification(user.getUserQualification());
//		return setHeaderResponse(userResponse);
		return userResponse;
	}

//	private UserResponse setHeaderResponse(UserResponse userResponse) {
//		HttpHeaders response = new HttpHeaders();
//		response.set("Version", "1.0.1");
//		return null;
//	}

	@Override
	public UserResponse userRegister(UserRequest userRequest) {
		User user = setUserRequest(userRequest);
		user = userRepository.save(user);
		topicPublish.sendTopic(user);
		UserEducationRequest userEducationRequest = setUserEducationRequest(user);
		saveUserEducation(userEducationRequest);
		return setResponse(user);
	}

	@Async("asyncExecutor")
	public void saveUserEducation(UserEducationRequest userEducationRequest) {
//		myfeignClinet.saveUserEducation(userEducationRequest);
		genericRestTemplate.execuateExchange(userEducationRequest, userEducationProperties.getBaseUrl(),
				HttpMethod.POST, UserEducationResponse.class);
	}

	private UserEducationRequest setUserEducationRequest(User user) {
		UserEducationRequest userEducationRequest = new UserEducationRequest();
		userEducationRequest.setEmail(user.getUserEmail());
		userEducationRequest.setPercentage(user.getUserPercentage());
		userEducationRequest.setQualification(user.getUserQualification());
		return userEducationRequest;
	}

	private User setUserRequest(UserRequest userRequest) {
		User user = new User();
		user.setUserEmail(userRequest.getUserEmail());
		user.setUserLocation(userRequest.getUserLocation());
		user.setUserMobile(userRequest.getUserMobile());
		user.setUserName(userRequest.getUserName());
		user.setUserPassword(userRequest.getUserPassword());
		user.setUserPercentage(userRequest.getUserPercentage());
		user.setUserQualification(userRequest.getUserQualification());
		return user;
	}

	@Override
	public UserResponse userLogin(UserRequest userRequest) throws Exception {
		UserResponse userResponse = null;
		User user = userValidation.validateEmail(userRequest.getUserEmail());
		if (user.getUserEmail().equalsIgnoreCase(userRequest.getUserEmail())
				&& user.getUserPassword().equalsIgnoreCase(userRequest.getUserPassword())) {
			userResponse = setResponse(user);
		} else {
			throw new Exception("Invalid credentials");
		}
		return userResponse;
	}

}
