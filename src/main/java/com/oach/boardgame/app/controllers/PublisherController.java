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

import com.oach.boardgame.app.models.Publisher;
import com.oach.boardgame.app.services.impl.PublisherServiceImpl;

@RestController
@RequestMapping("/boardGames")
public class PublisherController {
	
	@Autowired
	PublisherServiceImpl service;
	
	@GetMapping("/publishers")
	public List<Publisher> getAllPublishers() {
		return service.getAllPublisher();
	}

	@GetMapping("/publishers/{id}")
	public Publisher getPublisher(@PathVariable("id") String id) {
		return service.getPublisherById(id);
	}
	
	@PostMapping("/publishers")
	public ResponseEntity<Publisher> createPublisher(@Validated @RequestBody Publisher publisher) {
		Publisher publisherSaved = service.createPublisher(publisher);
		return new ResponseEntity<Publisher>(publisherSaved, HttpStatus.CREATED);
	}
	
	@PutMapping("/publishers/{id}")
	public ResponseEntity<Publisher> updatePublisher(@Validated @RequestBody Publisher publisher, @PathVariable("id") String id ){
		publisher.setId(id);
		Publisher publisherUpdated = service.updatePublisherById(publisher);
		if(publisherUpdated != null) {
			return new ResponseEntity<Publisher>(publisherUpdated, HttpStatus.OK);
		}
		return new ResponseEntity<Publisher>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/publishers/{id}")
	public ResponseEntity<Publisher> deletePublisher(@PathVariable("id") String id){
		if(service.deletePublisherById(id)) {
			return new ResponseEntity<Publisher>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Publisher>(HttpStatus.NOT_FOUND);
	}
	
}
