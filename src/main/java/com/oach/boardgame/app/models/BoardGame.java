package com.oach.boardgame.app.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "BoardGames")
public class BoardGame {
	@Id
	private String id;
	@Indexed(unique = true)
	private String title;
	private int year;
	private String players;
	private Genre genre;
	private Designer designer;
	private Artist artist;
	private String description;
	private int stock;
	private double price;
	
	public BoardGame() {
		
	}

	public BoardGame(String id, String title, int year, String players, 
					Genre genre, Designer designer, Artist artist,
					String description, int stock, double price) {
	
		this.id = id;
		this.title = title;
		this.year = year;
		this.players = players;
		this.genre = genre;
		this.designer = designer;
		this.artist = artist;
		this.description = description;
		this.stock = stock;
		this.price = price;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getPlayers() {
		return players;
	}

	public void setPlayers(String players) {
		this.players = players;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Genre getGenre() {
		return genre;
	}

	public Designer getDesigner() {
		return designer;
	}

	public Artist getArtist() {
		return artist;
	}

}
