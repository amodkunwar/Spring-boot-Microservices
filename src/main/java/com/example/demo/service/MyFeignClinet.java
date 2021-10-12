//package com.example.demo.service;
//
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//
//import com.example.demo.model.MovieResponse;
//import com.example.demo.model.UserEducationRequest;
//import com.example.demo.model.UserEducationResponse;
//
//@FeignClient(name="USEREDUCATION", url = "http://localhost:9091/user/education")
//public interface MyFeignClinet {
//
//	@GetMapping(value = "{email}")
//	public MovieResponse getMovie(@PathVariable("email") String email);
////	
//	@PostMapping(value = "/save")
//	public UserEducationResponse saveUserEducation(@RequestBody UserEducationRequest userEducationRequest);
//
//}
