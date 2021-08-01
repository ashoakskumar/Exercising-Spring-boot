package com.example.demo;

import org.springframework.stereotype.Component;

import com.example.demo.bean.model.HelloMessage;

@Component
public class HelloMessageService {

	public void printMsg() {
		HelloMessage msg = new HelloMessage("AutoWire Test");
		System.out.println("Pring Msssage: " + msg.getMessage());
	}
}
