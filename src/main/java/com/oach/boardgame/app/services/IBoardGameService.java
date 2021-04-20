package com.oach.boardgame.app.services;

import java.util.List;

import com.oach.boardgame.app.models.BoardGame;

public interface IBoardGameService {

	BoardGame createBoardGame(BoardGame boardGame);
	
	List<BoardGame> getAllBoardGames();
	
	BoardGame getBoardGameById(String id);
	
	BoardGame updateBoardGameById(BoardGame boardGame);
	
	boolean deleteBoardGameById(String id);
}
