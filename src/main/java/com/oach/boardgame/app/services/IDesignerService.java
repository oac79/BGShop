package com.oach.boardgame.app.services;

import java.util.List;

import com.oach.boardgame.app.models.BoardGame;
import com.oach.boardgame.app.models.Designer;


public interface IDesignerService {

	Designer createDesigner(Designer designer);
	
	List<Designer> getAllDesigners();
	
	Designer getDesignerById(String id);
	
	Designer updateDesignerById(Designer designer);
	
	Designer addToDesignerNewBoardGame(Designer designer, BoardGame boardGame);
	
	boolean deleteDesignerById(String id);
	
}
