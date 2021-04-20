package com.oach.boardgame.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oach.boardgame.app.models.User;
import com.oach.boardgame.app.services.impl.UserServiceImpl;

@RestController
@RequestMapping("/boardGames")
public class UserController {

	@Autowired
	UserServiceImpl service;
	
	@GetMapping("/users")
	public List<User> getAllUsers(){
		return service.getAllUsers();
	}
	
	@GetMapping("/users/{id}")
	public User getUser(@PathVariable("id") String id) {
		return service.getUserById(id);
	}
	
	@PostMapping("/users")
	public ResponseEntity<User> createUser(@Validated @RequestBody User user){
		User userSaved = service.createUser(user);
		return new ResponseEntity<User>(userSaved, HttpStatus.CREATED);
	}
	
	@PutMapping("/users/{id}")
	public ResponseEntity<User> updateUser(@Validated @RequestBody User user, @PathVariable("id") String id){
	user.setId(id);
	User userUpdated = service.updateUser(user);
	if(userUpdated != null) {
		return new ResponseEntity<User>(userUpdated, HttpStatus.OK);
	}
	return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/users/{id}")
	public ResponseEntity<User> deleteUserById(@PathVariable("id")String id){
		if(service.deleteUserById(id)) {
			return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
	}
	
}
