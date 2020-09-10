package com.oach.boardgame.app.models;

import java.util.List;

public class Publisher {

	private String id;
	private String name;
	private List<BoardGame> boardGames;
	
	public Publisher() {
		
	}

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
