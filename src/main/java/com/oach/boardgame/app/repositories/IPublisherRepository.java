package com.oach.boardgame.app.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.oach.boardgame.app.models.Publisher;

public interface IPublisherRepository extends MongoRepository<Publisher, String>{
	

}
