package com.amod.common.logging;

import org.apache.commons.lang.exception.ExceptionUtils;

public class LoggerMgmtServiceUtils {

	private LoggerMgmtServiceUtils() {
	}

	public static String getStackTraceException(Exception e) {
		return ExceptionUtils.getStackTrace(e);
	}

}
