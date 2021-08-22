package com.ashok.example.demo.service;

import java.util.List;

import com.ashok.example.demo.entity.Employee;

public interface EmployeeServiceInterface {
	public Employee addEmployee(Employee employee);

	public List<Employee> getAllEmployees();

	public Employee getEmpById(Long empidL);

	public void deleteEmpById(Long empidL);
	
	
}
