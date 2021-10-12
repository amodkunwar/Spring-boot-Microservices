package com.amod.common.logging;

import org.slf4j.Logger;

public interface ILogger {

	public abstract void timing(Class<?> clazz, String messagePattern, Object... arguments);

	public abstract void plainTiming(Class<?> clazz, String messagePattern, Object... arguments);

	public abstract void info(Class<?> clazz, String messagePattern, Object... arguments);

	public abstract void debug(Class<?> clazz, String messagePattern, Object... arguments);

	public abstract void warn(Class<?> clazz, String messagePattern, Object... arguments);

	public abstract void error(Class<?> clazz, String messagePattern, Object... arguments);

	public abstract void trace(Class<?> clazz, String messagePattern, Object... arguments);

	public abstract Logger getLogger(Class<?> clazz);

	public default boolean isInfoEnabled(Class<?> clazz) {
		return false;
	}

	public default boolean isDebugEnabled(Class<?> clazz) {
		return false;
	}

	public default boolean isWarnEnabled(Class<?> clazz) {
		return false;
	}

	public Logger getRootLogger();

	public abstract void dynamicInfo(String loggerName, Class<?> clazz, String messagePattern, Object... arguments);

}
