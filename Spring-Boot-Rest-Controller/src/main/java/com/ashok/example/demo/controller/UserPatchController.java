package com.ashok.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ashok.example.demo.model.User;
import com.ashok.example.demo.service.UserService;

@RestController
public class UserPatchController {

	@Autowired
	UserService service;
	
	@PatchMapping(value = {"/patch/partial/insert/{id}"})
	public ResponseEntity<User> patchRequest(@RequestBody User user,@PathVariable("id") long id) {
		return new ResponseEntity<User>(service.patchUser(user, id),HttpStatus.OK);
	}
}
