package com.oach.boardgame.app.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oach.boardgame.app.models.BoardGame;
import com.oach.boardgame.app.repositories.IBoardGameRepository;
import com.oach.boardgame.app.services.IBoardGameService;

@Service
public class BoardGameServiceImpl implements IBoardGameService {

	@Autowired 
	IBoardGameRepository repository;
	
	@Override
	public BoardGame createBoardGame(BoardGame boardGame) {
		return repository.insert(boardGame);
	}

	@Override
	public List<BoardGame> getAllBoardGames() {
		return repository.findAll();
	}

	@Override
	public BoardGame getBoardGameById(String id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public BoardGame updateBoardGameById(BoardGame boardGame) {
		if(repository.existsById(boardGame.getId())) {
			return repository.save(boardGame);
		}
		return null;
	}

	@Override
	public boolean deleteBoardGameById(String id) {
		if(repository.existsById(id)) {
			repository.deleteById(id);
			return true;
		}
		return false;
	}



}
