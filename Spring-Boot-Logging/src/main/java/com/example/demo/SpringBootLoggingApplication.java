package com.example.demo;


import org.slf4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SpringBootLoggingApplication {

	private static final Logger logger = org.slf4j.LoggerFactory.getLogger(SpringBootLoggingApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(SpringBootLoggingApplication.class, args);
		logger.debug("This is debug logger");
		logger.warn("This is warn logger");
		logger.error("This is error logger");
		logger.info("This is info logger");
	}

	@GetMapping("/log")
	public ResponseEntity<String> getLog() {
		logger.info("This is info logger - getLog method");
		return new ResponseEntity<>("Spring boot log", HttpStatus.OK);
	}
}
