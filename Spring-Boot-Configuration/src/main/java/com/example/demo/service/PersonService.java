package com.example.demo.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.model.Person;
@Configuration
public class PersonService {

	@Bean("person1")
	public Person getPerson1() {
		Person person = new Person();
		person.setAge(25);
		person.setName("Kumar");
		return person;
	}
	@Bean("person2")
	public Person getPerson2() {
		Person person = new Person();
		person.setAge(30);
		person.setName("vimal");
		return person;
	}
}
