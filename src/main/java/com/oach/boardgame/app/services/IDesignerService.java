package com.oach.boardgame.app.services;

import java.util.List;

import com.oach.boardgame.app.models.Designer;


public interface IDesignerService {

	Designer createDesigner(Designer designer);
	
	List<Designer> getAllDesigners();
	
	Designer getDesignerById(String id);
	
	Designer updateDesignerById(Designer designer);
	
	boolean deleteDesignerById(String id);
	
}
