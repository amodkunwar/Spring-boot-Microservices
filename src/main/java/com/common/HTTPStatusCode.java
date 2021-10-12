package com.common;

public enum HTTPStatusCode {
	RESPONSE_CD_SUCCESS("200"), RESPONSE_CD_NOTFOUND("404"), RESPONSE_CD_INTERNALSERVERERROR("500"),
	RESPONSE_CD_FORBIDDEN("403"), RESPONSE_CD_BADREQUEST("400"), RESPONSE_CD_METHODNOTALLOWED("405"),
	UNPROCESSABLE_ENTITY("422"), RESPONSE_CD_PRECONDITION_FAILED("412");

	private String value;

	private HTTPStatusCode(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return this.value;
	}
}
