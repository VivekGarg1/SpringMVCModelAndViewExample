package com.home.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.dao.UserDao;
import com.home.model.User;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;

	public List<User> getUsersList() {
		return userDao.getUserList();
	}

	public void createUser(User user) {
		userDao.createUser(user);
		
	}

}
