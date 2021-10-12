package com.amod.common.exception;

import com.common.HTTPStatusCode;

public class ApplicationException extends BaseException {

	private static final long serialVersionUID = 7852792618362088525L;

	private Object data;
	private String logLevel = "ERROR";

	public ApplicationException(Exception exception) {
		super(exception);
	}

	public ApplicationException(String version, HTTPStatusCode status, String internalMessage, Object data) {
		super(version, status, internalMessage);
		this.data = data;
	}

	public ApplicationException(String version, HTTPStatusCode status, String internalMessage, Object data,
			String logLevel) {
		super(version, status, internalMessage);
		this.data = data;
		this.logLevel = logLevel;
	}

	public ApplicationException(String version, HTTPStatusCode status, String internalMessage) {
		super(version, status, internalMessage);
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getLogLevel() {
		return logLevel;
	}

	public void setLogLevel(String logLevel) {
		this.logLevel = logLevel;
	}

}
