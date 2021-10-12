package com.example.demo.implementation.template;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

public interface IGenericeRestTemplate {

	public <T> ResponseEntity<T> execuateExchange(Object requestBody, String baseUrl, HttpMethod method, Class<T> clazz,
			String... params);

}
