package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.StandardEnvironment;

@SpringBootApplication
public class SpringBootProfileApplication {

	public static void main(String[] args) {
		//SpringApplication.run(SpringBootProfileApplication.class, args);
		SpringApplication application = new SpringApplication(SpringBootProfileApplication.class);
		ConfigurableEnvironment environment = new StandardEnvironment();
		environment.setDefaultProfiles("dev");
		application.setEnvironment(environment);
		application.run(args);
	}

}
