package com.amod.common.exception;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

public class ExceptionResponse {

	private String version;
	private ExceptionMessage<?> message;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private List<String> validationErrors = new ArrayList<>();

	public ExceptionResponse() {
	}

	public ExceptionResponse(String version, ExceptionMessage<?> message) {
		super();
		this.version = version;
		this.message = message;
	}

	public ExceptionResponse(String version, ExceptionMessage<?> message, List<String> validationErrors) {
		super();
		this.version = version;
		this.message = message;
		this.validationErrors = validationErrors;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public ExceptionMessage<?> getMessage() {
		return message;
	}

	public void setMessage(ExceptionMessage<?> message) {
		this.message = message;
	}

	public List<String> getValidationErrors() {
		return validationErrors;
	}

	public void setValidationErrors(List<String> validationErrors) {
		this.validationErrors = validationErrors;
	}

}
