package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.HelloMessageService;
import com.example.demo.service.OptionalDependencyService;

@Configuration
public class OptionalConfig {
	/*
	 * @Autowired(required = false) HelloMessageService service;
	 * 
	 * @Bean
	 * 
	 * public OptionalDependencyService service() { if(service == null) {
	 * System.out.println("This is optional false"); } return new
	 * OptionalDependencyService(new HelloMessageService()); }
	 */
	
}
