package com.home.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.home.model.User;

@Repository
public class UserDao {

	private static List<User> list = null;
	static {
		list = new ArrayList<User>();
		list.add(new User("Vivek Garg", 23, "v@gmail.com", "India"));
		list.add(new User("Sean", 35, "s@gmail.com", "UK"));
		list.add(new User("Paul", 38, "p@gmail.com", "USA"));
		list.add(new User("Louisa", 30, "l@gmail.com", "AUS"));
	}

	public List<User> getUserList() {
		return list;
	}

	public void createUser(User user) {
		list.add(user);
	}

}
