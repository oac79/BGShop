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

import com.oach.boardgame.app.models.Artist;
import com.oach.boardgame.app.services.IArtistService;

@RestController
@RequestMapping("/boardGames")
public class ArtistController {
	
	@Autowired
	IArtistService service;
	
	@GetMapping("/artists")
	public List<Artist> getAllArtists() {
		return service.getAllArtists();
	}
	
	@GetMapping("/artists/{id}")
	public Artist getArtist(@PathVariable("id") String id) {
		return service.getArtistById(id);
	}
	
	@PostMapping("/artists")
	public ResponseEntity<Artist> createArtist(@Validated @RequestBody Artist artist) {
		Artist artistSaved = service.createArtist(artist);
		return new ResponseEntity<Artist>(artistSaved, HttpStatus.CREATED);
	}
	
	@PutMapping("/artists/{id}")
	public ResponseEntity<Artist> updateArtist(@Validated @RequestBody Artist artist, @PathVariable("id") String id ){
		artist.setId(id);
		Artist artistUpdated = service.updateArtistById(artist);
		if(artistUpdated != null) {
			return new ResponseEntity<Artist>(artistUpdated, HttpStatus.OK);
		}
		return new ResponseEntity<Artist>(HttpStatus.NOT_FOUND);
		
	}
	
	@DeleteMapping("/artists/{id}")
	public ResponseEntity<Artist> deleteArtist(@PathVariable String id){
		if(service.deleteArtistById(id)) {
			return new ResponseEntity<Artist>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Artist>(HttpStatus.NOT_FOUND);
	}

}
