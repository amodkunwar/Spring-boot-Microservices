package com.example.demo.jms;

import static com.example.demo.jms.JmsConfig.USER_TOPIC;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.example.demo.entity.User;

@Component
public class UserSubscriber2 {
	@JmsListener(destination = USER_TOPIC, containerFactory = "jmsContainerFactory")
	public void receiveMessage(User user) {
		System.out.println("Receiver2: " + user);
	}
}
