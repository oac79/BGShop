package com.oach.boardgame.app.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.oach.boardgame.app.models.Artist;

public interface IArtistRepository extends MongoRepository<Artist, String>{

}
