package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.model.Option;

@Service
public class OptionalDependencyService {
@Autowired(required = false)
Option service;
	public void setService(Option service) {
		this.service = service;
	}
	public Option getService() {
		return this.service;
	}
	
}
