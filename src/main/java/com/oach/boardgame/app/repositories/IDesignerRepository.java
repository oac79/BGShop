package com.oach.boardgame.app.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.oach.boardgame.app.models.Designer;

public interface IDesignerRepository extends MongoRepository<Designer, String>{

	//Importante MongoRepository nos genera el DAO
	
	//Implementar consultas personalizadas
	
}
