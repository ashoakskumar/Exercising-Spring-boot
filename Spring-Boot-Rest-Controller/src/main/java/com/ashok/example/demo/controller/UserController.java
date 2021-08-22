package com.ashok.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ashok.example.demo.model.User;
import com.ashok.example.demo.service.UserService;

@RestController(value = "/api")
public class UserController {

	@Autowired
	UserService service;
	
	@GetMapping("/user/{id}")
	public ResponseEntity<User> getUserById(@PathVariable long id){
		return new ResponseEntity<User>(service.getById(id).get(),HttpStatus.OK);
	}
	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUser(){
		return new ResponseEntity<List<User>>(service.getAll(),HttpStatus.OK);
	}
	// Value attribute
	@GetMapping(value = {"/user/all","/user/many"})
	public ResponseEntity<List<User>> getUsers(){
		return new ResponseEntity<List<User>>(service.getAll(),HttpStatus.OK);
	}
	@GetMapping(value = "/user/one/*/{id}")
	public ResponseEntity<User> getUsersWildcard(@PathVariable long id){
		return new ResponseEntity<User>(service.getById(id).get(),HttpStatus.OK);
	}
	// Request param with value attribute
	@GetMapping(value = "/user/request/param/with/value")
	public ResponseEntity<User> getRequestParamWithValue(@RequestParam(value = "id") long id) {
		return new ResponseEntity<User>(service.getById(id).get(),HttpStatus.OK);
	}
	// Request param without value attribute
	@GetMapping(value = "/user/request/param/without/value")
	public ResponseEntity<User> getRequestParamWithOutValue(@RequestParam long id) {
		return new ResponseEntity<User>(service.getById(id).get(),HttpStatus.OK);
	}
	// Request param with optional param
	@GetMapping(value = "/user/request/param/with/optional/param")
	public ResponseEntity<User> getRequestParamWithOptionalParam(@RequestParam(value ="id", required = true) long id) {
		return new ResponseEntity<User>(service.getById(id).get(),HttpStatus.OK);
	}
	// Request param with default value
	@GetMapping(value = "/user/request/param/with/default/value")
	public ResponseEntity<User> getRequestParamWithDefaultValue(@RequestParam(value="id",defaultValue = "1") long id) {
		return new ResponseEntity<User>(service.getById(id).get(),HttpStatus.OK);
	}
	//Param attribute with multiple method handler
	@GetMapping(value = "/user/request/param/attribute",params = {"id=3"})
	public ResponseEntity<User> getRequestParamAttributeId3(@RequestParam("id") long id) {
		return new ResponseEntity<User>(service.getById(id).get(),HttpStatus.OK);
	}
	@GetMapping(value = "/user/request/param/attribute",params = {"id=2"})
	public ResponseEntity<User> getRequestParamAttributeId2(@RequestParam("id") long id) {
		return new ResponseEntity<User>(service.getById(id).get(),HttpStatus.OK);
	}
	//Request param with reqular expression and dynamic url
	@GetMapping(value = "/user/request/param/regular/expression/{id:[0-9]+}")
	public ResponseEntity<User> getRequestParamWithRegularExp(@PathVariable("id") long id) {
		return new ResponseEntity<User>(service.getById(id).get(),HttpStatus.OK);
	}
		//	@RequestMapping With Headers
	  @GetMapping(value = "/head", headers = {
		        "content-type=text/plain"
		    })
		    String post() {
		        return "Mapping applied along with headers";
		    }
}
