package com.oach.boardgame.app.services;

import java.util.List;

import com.oach.boardgame.app.models.User;

public interface IUserService {
	
	User createUser(User user);
	
	List<User> getAllUsers();
	
	User getUserById(String id);
	
	User updateUser(User user);
	
	boolean deleteUserById(String id);
}
