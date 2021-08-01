package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class ProfileController {

	@Value("${app.message}")
	private String welcomeMsg;
	
	@GetMapping("/welcome")
	public String welcomeMsg() {
		return welcomeMsg;
	}
}
