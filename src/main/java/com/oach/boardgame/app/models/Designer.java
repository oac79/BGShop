package com.oach.boardgame.app.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Designers")
public class Designer extends Person {

	@Id
	private String id;
	
	@DBRef
	private List<BoardGame> boardGames;

	public Designer(String id, String name, String lastName, List<BoardGame> boardGames) {
		super(name, lastName); //llama al constructor de la clase padre
		this.id = id;
		this.boardGames=boardGames;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<BoardGame> getBoardGames() {
		return boardGames;
	}
	

	
	
}
