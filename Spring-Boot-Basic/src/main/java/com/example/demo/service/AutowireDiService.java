package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.HelloMessageService;

@Service
public class AutowireDiService {

	
	HelloMessageService service;
	
	@Autowired
	public AutowireDiService(HelloMessageService service) {
		this.service = service;
	}
	
	public void printMsg() {
		service.printMsg();
	}
}
