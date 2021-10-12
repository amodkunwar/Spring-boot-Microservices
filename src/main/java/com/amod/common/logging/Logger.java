package com.amod.common.logging;

import org.slf4j.LoggerFactory;
import org.slf4j.event.Level;
import org.springframework.stereotype.Component;

import com.common.IAppConstants;

@Component
public class Logger implements ILogger {

	private org.slf4j.Logger selfLogger = LoggerFactory.getLogger(Logger.class);
	ch.qos.logback.classic.Logger rootLogger = (ch.qos.logback.classic.Logger) LoggerFactory
			.getLogger(org.slf4j.Logger.ROOT_LOGGER_NAME);
	ch.qos.logback.classic.Logger plainProfilerLogger = (ch.qos.logback.classic.Logger) LoggerFactory
			.getLogger(IAppConstants.PLAIN_PROFILER.toString());
	ch.qos.logback.classic.Logger profilerLogger = (ch.qos.logback.classic.Logger) LoggerFactory
			.getLogger(IAppConstants.PROFILER.toString());

	public Logger() {
		selfLogger.debug("Logger initialized");
	}

	@Override
	public void timing(Class<?> clazz, String messagePattern, Object... arguments) {
		// TODO Auto-generated method stub

	}

	@Override
	public void plainTiming(Class<?> clazz, String messagePattern, Object... arguments) {
		// TODO Auto-generated method stub

	}

	@Override
	public void info(Class<?> clazz, String messagePattern, Object... arguments) {
//		if(this.loggingEnabled(clazz, Level.DEBUG,false)) {
//			doLogg
//		}
		
	}

	@Override
	public void debug(Class<?> clazz, String messagePattern, Object... arguments) {
		// TODO Auto-generated method stub

	}

	@Override
	public void warn(Class<?> clazz, String messagePattern, Object... arguments) {
		// TODO Auto-generated method stub

	}

	@Override
	public void error(Class<?> clazz, String messagePattern, Object... arguments) {
		// TODO Auto-generated method stub

	}

	@Override
	public void trace(Class<?> clazz, String messagePattern, Object... arguments) {
		// TODO Auto-generated method stub

	}

	@Override
	public org.slf4j.Logger getLogger(Class<?> clazz) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public org.slf4j.Logger getRootLogger() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void dynamicInfo(String loggerName, Class<?> clazz, String messagePattern, Object... arguments) {
		// TODO Auto-generated method stub

	}

}
