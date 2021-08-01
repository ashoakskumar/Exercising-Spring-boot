package com.example.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.example.demo.bean.model.HelloMessage;

@Configuration
@PropertySource("classpath:messages.properties")
public class HelloBeanConfig {

	@Value("${motd}")
	private String message;
	
	@Bean(name="myMessage")
	public HelloMessage helloMessage() {
		HelloMessage messages = new HelloMessage(message);
		return messages;
	}
}
