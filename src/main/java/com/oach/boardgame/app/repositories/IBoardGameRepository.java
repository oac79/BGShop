package com.oach.boardgame.app.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.oach.boardgame.app.models.BoardGame;

public interface IBoardGameRepository extends MongoRepository<BoardGame, String>{

}
