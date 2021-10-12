package com.common;

public enum IAppConstants {
	LOG_LEVEL_INFO("info"), LOG_LEVEL_ERROR("error"), LOG_LEVEL_DEBUG("debug"), LOG_LEVEL_WARN("warn"),
	PLAIN_PROFILER("Plain_Profiler"), PROFILER("Profiler");

	private String value;

	IAppConstants(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return this.value;
	}

}
