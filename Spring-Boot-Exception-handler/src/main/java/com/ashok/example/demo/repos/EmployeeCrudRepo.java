package com.ashok.example.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ashok.example.demo.entity.Employee;
@Repository
public interface EmployeeCrudRepo extends JpaRepository<Employee, Long>{

}
