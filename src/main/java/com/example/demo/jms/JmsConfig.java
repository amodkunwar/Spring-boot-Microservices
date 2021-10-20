package com.example.demo.jms;

import org.apache.activemq.ActiveMQConnectionFactory;

/***
 * @author Amod
 */
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

@Configuration
public class JmsConfig {
	
	public static final String USER_TOPIC = "user-topic";

	@Bean
	public DefaultJmsListenerContainerFactory jmsContainerFactory() {
		DefaultJmsListenerContainerFactory defaultJmsListenerContainerFactory = new DefaultJmsListenerContainerFactory();
		defaultJmsListenerContainerFactory.setPubSubDomain(true);
		defaultJmsListenerContainerFactory.setConnectionFactory(connectionFactory());
		defaultJmsListenerContainerFactory.setMessageConverter(jacksonJmsMessageConverter());
		return defaultJmsListenerContainerFactory;
	}

	private MessageConverter jacksonJmsMessageConverter() {
		MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
		converter.setTargetType(MessageType.TEXT);
		converter.setTypeIdPropertyName("_type");
		return converter;
	}

	private CachingConnectionFactory connectionFactory() {
		CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory();
		ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
		activeMQConnectionFactory.setBrokerURL("tcp://localhost:61616");
		cachingConnectionFactory.setTargetConnectionFactory(activeMQConnectionFactory);
		return cachingConnectionFactory;
	}

}
