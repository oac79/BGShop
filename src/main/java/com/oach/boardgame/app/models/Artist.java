package com.oach.boardgame.app.models;

public class Artist extends Person {

	private String id;

	/*
	 * @DBRef private List<BoardGame> boardGames;
	 */

	public Artist(String id, String name, String lastName) {
		super(name, lastName); // llama al constructor de la clase padre
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	/*
	 * public List<BoardGame> getBoardGames() { return boardGames; }
	 */
}
