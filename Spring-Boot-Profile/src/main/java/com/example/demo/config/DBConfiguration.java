package com.example.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import lombok.Data;

@Configuration
@ConfigurationProperties("spring.datasource")
@Data
public class DBConfiguration {

	private String driverClassName;
	private String url;
	private String username;
	private String password;
	
	@Profile("dev")
	@Bean
	public String devDatabaseConnection() {
		System.out.println("Db connection for dev - H2");
		System.out.println("Driver class Name - Dev: " + driverClassName);
		System.out.println("Driver URL Name - Dev: " + url);
		System.out.println("user Name - Dev: " + username);
		return "Db connection for dev - H2";
	}
	@Profile("test")
	@Bean
	public String testDatabaseConnection() {
		System.out.println("Db connection for Test - H2");
		System.out.println("Driver class Name - Test: " + driverClassName);
		System.out.println("Driver URL Name - Test: " + url);
		System.out.println("user Name - Test: " + username);
		return "Db connection for Test - H2";
	}
	@Profile("prod")
	@Bean
	public String prodDatabaseConnection() {
		System.out.println("Db connection for Prod - H2");
		System.out.println("Driver class Name - Prod: " + driverClassName);
		System.out.println("Driver URL Name - Prod: " + url);
		System.out.println("user Name - Prod: " + username);
		return "Db connection for Prod - H2";
	}
}
