package com.amod.common.exception;

import com.common.HTTPStatusCode;

public class BaseException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String version;
	private HTTPStatusCode status;
	private String internalMessage;

	public BaseException() {
	}

	public BaseException(Exception exception) {
		super(exception);
	}

	public BaseException(String version, HTTPStatusCode status, String internalMessage) {
		super();
		this.version = version;
		this.status = status;
		this.internalMessage = internalMessage;
	}

	public BaseException(String message, Throwable throwable) {
		super(message, throwable);
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public HTTPStatusCode getStatus() {
		return status;
	}

	public void setStatus(HTTPStatusCode status) {
		this.status = status;
	}

	public String getInternalMessage() {
		return internalMessage;
	}

	public void setInternalMessage(String internalMessage) {
		this.internalMessage = internalMessage;
	}

}
