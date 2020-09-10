package com.oach.boardgame.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oach.boardgame.app.models.Artist;
import com.oach.boardgame.app.services.IArtistService;

@RestController
@RequestMapping("/api-artist")
public class ArtistController {
	
	@Autowired
	IArtistService service;
	
	@GetMapping("/artists")
	public List<Artist> getAllArtist() {
		return service.getAllArtist();
	}
	
	@GetMapping("/id/{id}")
	public Artist getArtistById(@PathVariable("id") String id) {
		return service.getArtistById(id);
	}
	

}
