package com.example.demo.jms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import static com.example.demo.jms.JmsConfig.USER_TOPIC;

import com.example.demo.entity.User;

@Service
public class TopicPublish {

	private static final Logger LOGGER = LoggerFactory.getLogger(TopicPublish.class);

	@Autowired
	private JmsTemplate jmsTemplate;

	public void sendTopic(User user) {
		LOGGER.info("Sending to Topic : ", user.getUserEmail());
		System.out.println(user);
		jmsTemplate.convertAndSend(USER_TOPIC, user);
	}

}
