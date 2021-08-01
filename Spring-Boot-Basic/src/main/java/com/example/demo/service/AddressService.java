package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.interfaces.IDAO;
@Service
public class AddressService {

	@Autowired()
	@Qualifier("contact")
	IDAO contact;
	@Autowired
	@Qualifier("address")
	IDAO address;
	public void print() {
		contact.results();
		address.results();
	}
}
