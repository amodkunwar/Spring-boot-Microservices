package com.example.demo.implementation.template;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class GenericRestTemplate implements IGenericeRestTemplate {

	private RestTemplate restTemplate;

	private static final Logger LOGGER = LoggerFactory.getLogger(GenericRestTemplate.class);

	public GenericRestTemplate() {
		restTemplate = new RestTemplateBuilder().errorHandler(new RestTemplateResponseErrorHandler()).build();
	}

	@Override
	public <T> ResponseEntity<T> execuateExchange(Object requestBody, String baseUrl, HttpMethod method, Class<T> clazz,
			String... params) {
		ResponseEntity<T> responseEntity = null;
		try {
			HttpHeaders header = new HttpHeaders();
			header.setContentType(MediaType.APPLICATION_JSON);
			header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//			UriComponentsBuilder builder = null;
//			if (Objects.nonNull(params)) {
//				builder = UriComponentsBuilder.fromHttpUrl(baseUrl).queryParam("Param1", params[0]).queryParam("Param2",
//						params[1]);
//			} else {
//				builder = UriComponentsBuilder.fromHttpUrl(baseUrl).path("/" + user.getUserEmail());
//			}
			// get
			// HttpEntity<Object> getRequest = new HttpEntity<Object>(header);
			// restTemplate.exchange(builder.toUriString(), method, postRequst, clazz);
			// post
			HttpEntity<Object> postRequst = new HttpEntity<>(requestBody,header);
			responseEntity = restTemplate.exchange(baseUrl, method, postRequst, clazz);
		} catch (HttpClientErrorException e) {
			LOGGER.warn("Warning message");
			e.printStackTrace();
		} catch (HttpServerErrorException e) {
			LOGGER.error("Warning message");
			e.printStackTrace();
		}
		 catch (Exception e) {
				LOGGER.error("Warning message");
				e.printStackTrace();
			}
		return responseEntity;
	}

	public RestTemplate getRestTemplate() {
		return restTemplate;
	}

	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

}
