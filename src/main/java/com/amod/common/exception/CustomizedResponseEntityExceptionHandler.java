package com.amod.common.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.amod.common.logging.LoggerMgmtServiceUtils;
import com.common.HTTPStatusCode;
import com.common.IAppConstants;

@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	private static final Logger exceptionLogger = LoggerFactory
			.getLogger(CustomizedResponseEntityExceptionHandler.class);

	@ExceptionHandler(ApplicationException.class)
	public final ResponseEntity<ExceptionResponse> handleApplicationExceptions(
			ApplicationException applicationException, WebRequest webRequest) {
		if (applicationException.getLogLevel().equalsIgnoreCase(IAppConstants.LOG_LEVEL_INFO.toString())) {
			exceptionLogger.info("Info: Caught Application exception : {}",
					LoggerMgmtServiceUtils.getStackTraceException(applicationException));
		} else if (applicationException.getLogLevel().equalsIgnoreCase(IAppConstants.LOG_LEVEL_ERROR.toString())) {
			exceptionLogger.info("Error: Caught Application exception : {}",
					LoggerMgmtServiceUtils.getStackTraceException(applicationException));
		}

		else if (applicationException.getLogLevel().equalsIgnoreCase(IAppConstants.LOG_LEVEL_WARN.toString())) {
			exceptionLogger.info("Warn: Caught Application exception : {}",
					LoggerMgmtServiceUtils.getStackTraceException(applicationException));
		}

		else if (applicationException.getLogLevel().equalsIgnoreCase(IAppConstants.LOG_LEVEL_DEBUG.toString())) {
			exceptionLogger.info("Debug: Caught Application exception : {}",
					LoggerMgmtServiceUtils.getStackTraceException(applicationException));
		}

		ExceptionMessage<Object> exceptionMessage = new ExceptionMessage<Object>(applicationException.getStatus(),
				applicationException.getInternalMessage(), applicationException.getData());
		ExceptionResponse exceptionResponse = new ExceptionResponse(applicationException.getVersion(),
				exceptionMessage);
		return new ResponseEntity<>(exceptionResponse, getHttpStatus(applicationException.getStatus()));
	}

	public HttpStatus getHttpStatus(HTTPStatusCode status) {
		switch (status) {
		case RESPONSE_CD_SUCCESS:
			return HttpStatus.OK;
		case RESPONSE_CD_NOTFOUND:
			return HttpStatus.NOT_FOUND;
		case RESPONSE_CD_INTERNALSERVERERROR:
			return HttpStatus.INTERNAL_SERVER_ERROR;
		case RESPONSE_CD_FORBIDDEN:
			return HttpStatus.FORBIDDEN;
		case RESPONSE_CD_BADREQUEST:
			return HttpStatus.BAD_REQUEST;
		case RESPONSE_CD_METHODNOTALLOWED:
			return HttpStatus.METHOD_NOT_ALLOWED;
		case UNPROCESSABLE_ENTITY:
			return HttpStatus.UNPROCESSABLE_ENTITY;
		case RESPONSE_CD_PRECONDITION_FAILED:
			return HttpStatus.PRECONDITION_FAILED;
		default:
			return HttpStatus.INTERNAL_SERVER_ERROR;
		}
	}

}
