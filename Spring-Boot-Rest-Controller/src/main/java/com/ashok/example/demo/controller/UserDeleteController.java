package com.ashok.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ashok.example.demo.model.User;
import com.ashok.example.demo.service.UserService;
@RestController
public class UserDeleteController {

	@Autowired
	private UserService service;
	@DeleteMapping("/delete/user")
	public ResponseEntity<String> deleteUser(@RequestBody User user) {
		return new ResponseEntity<>(service.deleteUser(user),HttpStatus.OK);
	}
}
