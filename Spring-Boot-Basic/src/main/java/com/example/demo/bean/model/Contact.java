package com.example.demo.bean.model;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.example.demo.interfaces.IDAO;
@Component
@Qualifier("contact")
public class Contact implements IDAO{

	@Override
	public void results() {
		System.out.println("This is contact");
	}

}
