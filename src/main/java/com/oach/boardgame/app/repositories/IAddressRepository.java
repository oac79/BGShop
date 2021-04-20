package com.oach.boardgame.app.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.oach.boardgame.app.models.Address;

public interface IAddressRepository extends MongoRepository<Address, String> {

}
