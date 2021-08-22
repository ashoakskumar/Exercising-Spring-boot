package com.ashok.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ashok.example.demo.model.User;
import com.ashok.example.demo.service.UserService;

@RestController
public class UserPutController {

	@Autowired
	UserService service;
	@PutMapping(value = {"/put/update"})
	public ResponseEntity<User> updateUser(@RequestParam(value = "id") long id, @RequestBody final User user) {
		return new ResponseEntity<User>(service.updateUser(user, id),HttpStatus.OK);
	}
}
