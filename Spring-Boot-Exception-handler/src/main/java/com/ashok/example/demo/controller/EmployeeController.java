package com.ashok.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashok.example.demo.custom.exception.BusinessException;
import com.ashok.example.demo.custom.exception.ControllerException;
import com.ashok.example.demo.custom.exception.RecordNotFoundException;
import com.ashok.example.demo.entity.Employee;
import com.ashok.example.demo.service.EmployeeServiceInterface;

@RestController
@RequestMapping("/code")
public class EmployeeController {

	@Autowired
	private EmployeeServiceInterface service;
	
	@PostMapping("/save")
	public ResponseEntity<?> addEmployee(@RequestBody Employee employee) {
		try {
		return new ResponseEntity<Employee>(service.addEmployee(employee),HttpStatus.CREATED);
		} catch(BusinessException e) {
			ControllerException exception = new ControllerException(e.getErrorCode(),e.getErrorMessage());
			return new ResponseEntity<ControllerException>(exception,HttpStatus.BAD_REQUEST);
		}catch(Exception e) {
			ControllerException exception = new ControllerException("60003","Something went wrong in controller");
			return new ResponseEntity<ControllerException>(exception,HttpStatus.BAD_REQUEST);
		}

	}
	@GetMapping("/all")
	public ResponseEntity<List<Employee>> getAllEmployee() {
		return new ResponseEntity<List<Employee>>(service.getAllEmployees(),HttpStatus.OK);
	}
	@GetMapping("/get/emp/{empId}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("empId") Long id) {
		Employee employee = service.getEmpById(id);
		if(employee == null ) {
			throw new RecordNotFoundException("Record Not Found:" +id);
		}
		return new ResponseEntity<Employee>(service.getEmpById(id),HttpStatus.OK);
	}
	@DeleteMapping("/delete/{empId}")
	public ResponseEntity<Void> deleteEmployeeById(@PathVariable("empId") Long id) {
		service.deleteEmpById(id);
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}
	
}
