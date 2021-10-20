package com.example.demo.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import static com.example.demo.jms.JmsConfig.USER_TOPIC;
import com.example.demo.entity.User;

@Component
public class UserSubscriber {

	@JmsListener(destination = USER_TOPIC, containerFactory = "jmsContainerFactory")
	public void receiveMessage(User user) {
		System.out.println("Receiver1: " + user);
	}
	
}
