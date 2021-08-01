package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.HelloMessageService;
@Service
public class AutowireDIPropertyService {
	@Autowired
	HelloMessageService service;
	
	
	public void printMsg() {
		this.service.printMsg();
	}
}
