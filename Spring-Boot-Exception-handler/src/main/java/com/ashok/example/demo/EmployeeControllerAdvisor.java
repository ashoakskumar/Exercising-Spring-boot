package com.ashok.example.demo;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ashok.example.demo.custom.exception.ControllerException;
import com.ashok.example.demo.custom.exception.RecordNotFoundException;

@ControllerAdvice
public class EmployeeControllerAdvisor {
	
	  
	  @ExceptionHandler(NoSuchElementException.class) public ResponseEntity<String>
	  handleNoSuchElement(NoSuchElementException noSuchElementException) { return
	  new ResponseEntity<String>("No record found for the given input",HttpStatus.
	  BAD_REQUEST); }
	 
	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<?> recordNotFound(RecordNotFoundException ex) {
		ControllerException ce = new ControllerException("6006",
				"REcord not found for the given input: " + ex.getLocalizedMessage());
		return new ResponseEntity<ControllerException>(ce, HttpStatus.NOT_FOUND);
	}
}
