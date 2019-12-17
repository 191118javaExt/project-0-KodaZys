package com.revature.service;

import java.util.List;

import com.revature.DAOpackage.DAO;
import com.revature.DAOpackage.UserDao;
import com.revature.models.User;

public class UserService {
	
	static DAO<User, Integer> userDao = new UserDao();
	
	public List<User> getAllUsers(){
		List<User> users = userDao.findAll();
		if (users.size() == 0) return null;
		return users;
	}
	
	public List<String> getAllUsernames(){
		List<String> usernames = userDao.findAllUsernames();
		return usernames;
	}
	
	public User getUserByUsername(String username) {
		User u = userDao.findByUsername(username);
		return u;
	}
	
	public void createUser(User u) {
		userDao.create(u);
	}
	
}

