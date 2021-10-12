package com.example.demo.config;

import java.util.concurrent.Executor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class AsyncConfig {

	  @Bean(name = "asyncExecutor")
	    public Executor asyncExecutor() 
	    {
	        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
	        executor.setCorePoolSize(3);
	        executor.setMaxPoolSize(3);
	        executor.setQueueCapacity(100);
	        executor.setThreadNamePrefix("AsynchThread-");
	        executor.initialize();
	        return executor;
	    }
	
}
