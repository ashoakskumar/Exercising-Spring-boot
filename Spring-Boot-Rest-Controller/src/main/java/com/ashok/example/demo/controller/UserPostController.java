package com.ashok.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ashok.example.demo.model.User;
import com.ashok.example.demo.service.UserService;

@RestController
public class UserPostController {

	@Autowired
	UserService service;
	@PostMapping(path = {"post/create/user"})
	public ResponseEntity<User> createUser(@RequestBody User user ) {
		return new ResponseEntity<User>(service.createUser(user),HttpStatus.CREATED);
	}
	@PostMapping(path = {"post/produces/create/user"},produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> createUserProduces(@RequestBody User user ) {
		return new ResponseEntity<User>(service.createUser(user),HttpStatus.OK);
	}
	@PostMapping(path = {"post/consumes/create/user/{id}"},consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> createUserConsumes(@RequestBody User user,@PathVariable("id")long id ) {
		System.out.println("id:" + id);
		return new ResponseEntity<User>(service.createUser(user),HttpStatus.OK);
	}
}
