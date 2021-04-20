package com.oach.boardgame.app.services;

import java.util.List;

import com.oach.boardgame.app.models.Publisher;

public interface IPublisherService {

	Publisher createPublisher(Publisher publisher);
	
	List<Publisher> getAllPublisher();
	
	Publisher getPublisherById(String id);
	
	Publisher updatePublisherById(Publisher publisher);
	
	boolean deletePublisherById(String id);
}
