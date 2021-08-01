package com.example.demo.bean.model;

import org.springframework.stereotype.Component;

import com.example.demo.interfaces.IDAO;
@Component("address")
public class Address implements IDAO{

	@Override
	public void results() {
		System.out.println("This is Address");
	}

}
