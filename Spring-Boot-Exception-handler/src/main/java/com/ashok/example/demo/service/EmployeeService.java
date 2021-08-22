package com.ashok.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashok.example.demo.custom.exception.BusinessException;
import com.ashok.example.demo.custom.exception.RecordNotFoundException;
import com.ashok.example.demo.entity.Employee;
import com.ashok.example.demo.repos.EmployeeCrudRepo;
@Service
public class EmployeeService implements EmployeeServiceInterface{
	
	@Autowired
	EmployeeCrudRepo repo;

	@Override
	public Employee addEmployee(Employee employee) {
		try {
		if(employee.getName().isEmpty() || employee.getName().length() == 0) {
			throw new BusinessException("60001", "Pl send proper name, it is blank");
		}
		Employee savedEmp = repo.save(employee);
	
		return savedEmp;
		} catch(IllegalArgumentException exception) {
			throw new BusinessException("60002", "Given employee name is null: " + exception.getMessage());
		}catch(Exception exception) {
			throw new BusinessException("60003", "Some thing went wron in service layer: " + exception.getMessage());
		}
	}

	@Override
	public List<Employee> getAllEmployees() {
		return repo.findAll();
	}

	@Override
	public Employee getEmpById(Long empidL) {
		Optional<Employee> employee = repo.findById(empidL);
		if(employee.isEmpty()) {
			throw new RecordNotFoundException("Record Not Found:" +empidL);
		}
		return employee.get();
	}

	@Override
	public void deleteEmpById(Long empidL) {
		repo.deleteById(empidL);
	}

}
