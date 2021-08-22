package com.ashok.example.demo.service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.ashok.example.demo.dao.UserDAO;
import com.ashok.example.demo.model.User;

@Service
public class UserService {

	@Autowired
	UserDAO userDao;

	public List<User> getAll() {
		return userDao.findAll();
	}

	public Optional<User> getById(long id) {
		return userDao.findById(id);
	}
	
	public User createUser(User user) {
		List<User> users = getAll();
		long getId = users.stream().max(Comparator.comparing(User::getId)).get().getId();
		user.setId(++getId);
		return userDao.save(user);
	}
	public User updateUser(User user,long id) {
		User user1 = getById(id).get();
		user1.setLastName(user.getLastName());
		return userDao.save(user1);
	}
	public User patchUser(User user, long id) {
		User user1 = getById(id).get();
		boolean needUpdate = false;
		if(StringUtils.hasLength(user.getFirstName())) {
			needUpdate = true;
			user1.setFirstName(user.getFirstName());
		}
		if(StringUtils.hasLength(user.getLastName())) {
			needUpdate = true;
			user1.setLastName(user.getLastName());
		}
		if(StringUtils.hasLength(user.getEmail())) {
			needUpdate = true;
			user1.setEmail(user.getEmail());
		}
		if(StringUtils.hasLength(user.getDateOfBirth().toString())) {
			needUpdate = true;
			user1.setDateOfBirth(user.getDateOfBirth());
		}
		if(needUpdate) 
			return userDao.save(user1);
		return user1;
	}
	public String deleteUser(User user) {
		userDao.delete(user);
		return "deleted";
	}
}
