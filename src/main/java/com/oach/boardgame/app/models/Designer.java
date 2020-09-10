package com.oach.boardgame.app.models;

public class Designer extends Person {

	private String id;

	public Designer(String id, String name, String lastName) {
		super(name, lastName); //llama al constructor de la clase padre
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	

	
	
}
