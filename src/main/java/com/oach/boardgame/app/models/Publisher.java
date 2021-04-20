package com.oach.boardgame.app.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Publishers")
public class Publisher {

	@Id
	private String id;
	private String name;
	
	@DBRef
	private List<BoardGame> boardGames;
	
	public Publisher(String id, String name, List<BoardGame> boardGames) {
		this.id = id;
		this.name = name;
		this.boardGames = boardGames;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<BoardGame> getBoardGames() {
		return boardGames;
	}
	
	
	
	
}
