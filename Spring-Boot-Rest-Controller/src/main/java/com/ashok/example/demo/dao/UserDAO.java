package com.ashok.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ashok.example.demo.model.User;
@Repository
public interface UserDAO extends JpaRepository<User, Long>{

}