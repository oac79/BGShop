package com.oach.boardgame.app.models;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

@Document(collection = "BoardGames")
public class BoardGame {
	@Id
	private String id;
	@Indexed(unique = true)
	private String title;
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date publicationDate;
	private String players;
	private Genre genre;
	private String description;
	private int stock;
	private double price;
	private String image;

	public BoardGame(String id, String title, String players, 
					 Genre genre, String description, int stock, double price, String image) {
	
		this.id = id;
		this.title = title;
		this.publicationDate = new Date();
		this.players = players;
		this.genre = genre;
		this.description = description;
		this.stock = stock;
		this.price = price;
		this.image = image;	
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

	public Date getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}
