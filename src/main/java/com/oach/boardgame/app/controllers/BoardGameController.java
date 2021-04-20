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

import com.oach.boardgame.app.models.BoardGame;
import com.oach.boardgame.app.services.impl.BoardGameServiceImpl;

@RestController
@RequestMapping("/boardGames")
public class BoardGameController {

@Autowired
BoardGameServiceImpl service;

@GetMapping("")
public List<BoardGame> getAllBoardGames(){
	return service.getAllBoardGames();
}

@GetMapping("/{id}")
public BoardGame getBoardGame(@PathVariable("id") String id) {
	return service.getBoardGameById(id);	
}

@PostMapping("")
public ResponseEntity<BoardGame> createBoardGame(@Validated @RequestBody BoardGame boardGame) {
	BoardGame boardGameSaved = service.createBoardGame(boardGame);
	return new ResponseEntity<BoardGame>(boardGameSaved,HttpStatus.CREATED);
}

@PutMapping("/{id}")
public ResponseEntity<BoardGame> updateBoardGame(@Validated @RequestBody BoardGame boardGame, @PathVariable("id") String id){
	boardGame.setId(id);
	BoardGame updateBoardGame = service.updateBoardGameById(boardGame);
	if(updateBoardGame != null) {
		return new ResponseEntity<BoardGame>(updateBoardGame, HttpStatus.OK);
	}
	return new ResponseEntity<BoardGame>(updateBoardGame, HttpStatus.NOT_FOUND);	
}

@DeleteMapping("/{id}")
public ResponseEntity<BoardGame> deleteBoardGame(@PathVariable("id") String id){
	if(service.deleteBoardGameById(id)) {
		return new ResponseEntity<BoardGame>(HttpStatus.NO_CONTENT);
	}
	return new ResponseEntity<BoardGame>(HttpStatus.NOT_FOUND);
}

}
