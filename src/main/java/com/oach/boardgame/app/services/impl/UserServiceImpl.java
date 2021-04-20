package com.oach.boardgame.app.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oach.boardgame.app.models.User;
import com.oach.boardgame.app.repositories.IUserRepository;
import com.oach.boardgame.app.services.IUserService;

@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	public IUserRepository repository;

	@Override
	public User createUser(User user) {
		return repository.insert(user);
	}

	@Override
	public List<User> getAllUsers() {
		return repository.findAll();
	}

	@Override
	public User getUserById(String id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public User updateUser(User user) {
		if(repository.existsById(user.getId())) {
			return repository.save(user);
		}
		return null;
	}

	@Override
	public boolean deleteUserById(String id) {
		if(repository.existsById(id)) {
			repository.deleteById(id);
			return true;
		}
		return false;
	}

}
