package com.amod.common.exception;

import com.common.HTTPStatusCode;

public class ExceptionMessage<T> {

	private HTTPStatusCode status;

	private String internalMessage;

	private T data;

	public ExceptionMessage(HTTPStatusCode status, String internalMessage, T data) {
		super();
		this.status = status;
		this.internalMessage = internalMessage;
		this.data = data;
	}

	public ExceptionMessage(HTTPStatusCode status, String internalMessage) {
		super();
		this.status = status;
		this.internalMessage = internalMessage;
	}

	public ExceptionMessage() {
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

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
