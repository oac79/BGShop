package com.oach.boardgame.app.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.oach.boardgame.app.models.User;

public interface IUserRepository extends MongoRepository<User, String> {

}
