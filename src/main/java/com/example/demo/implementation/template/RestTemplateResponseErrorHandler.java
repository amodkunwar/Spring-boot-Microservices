package com.example.demo.implementation.template;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

public class RestTemplateResponseErrorHandler implements ResponseErrorHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(RestTemplateResponseErrorHandler.class);

	@Override
	public boolean hasError(ClientHttpResponse response) throws IOException {
		HttpStatus status = response.getStatusCode();
		LOGGER.warn("Error");
		return status.is4xxClientError() || status.is5xxServerError();
	}

	@Override
	public void handleError(ClientHttpResponse response) throws IOException {
		String responseAsString = toString(response.getBody());
		LOGGER.warn(responseAsString);
	}

	@Override
	public void handleError(URI url, HttpMethod httpMethod, ClientHttpResponse response) throws IOException {
		String responseAsString = toString(response.getBody());
		LOGGER.warn("URL: {}, HttpMethod: {}, ResponseBody: {}", url, httpMethod, responseAsString);
	}

	public String toString(InputStream inputStream) {
		try (Scanner scan = new Scanner(inputStream)) {
			scan.useDelimiter("\\A");
			return scan.hasNext() ? scan.next() : "";
		}
	}

	public class ApplicationHttpException extends RuntimeException {
		private static final long serialVersionUID = 1L;
		private final HttpStatus status;

		public ApplicationHttpException(String message, HttpStatus status) {
			super(message);
			this.status = status;
		}

		public HttpStatus getStatus() {
			return status;
		}

	}

}
