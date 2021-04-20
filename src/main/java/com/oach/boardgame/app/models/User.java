package com.oach.boardgame.app.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Users")
public class User extends Person {

	@Id
	private String id;
	
	@DBRef
	private Address address;
	
	private String email;
	private String password;
	private String telephone;
	
	public User() {
	
	}
	
	public User(String email, String password) {
		this.email = email;
		this.password = password;
	}
	
	public User(String name, String lastName, String email, String password, String telephone) {
		super(name, lastName);
		this.email = email;
		this.password = password;
		this.telephone = telephone;
	}
	
	public User(String name, String lastName, String email, String password, String telephone, Address address) {
		super(name, lastName);
		this.email = email;
		this.password = password;
		this.telephone = telephone;
		this.address = address;
	}
	
	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	public Address getAddress() {
		return address;
	}
	
	
	
	
}
