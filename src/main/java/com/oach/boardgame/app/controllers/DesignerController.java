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
import com.oach.boardgame.app.models.Designer;
import com.oach.boardgame.app.services.impl.DesignerServiceImpl;

@RestController
@RequestMapping("/boardGames")
public class DesignerController {

	@Autowired
	private DesignerServiceImpl service;
	
	@GetMapping("/designers")
	public List<Designer> getAllDesigners(){
		return service.getAllDesigners();
	}
	
	@GetMapping("/designers/{id}")
	public Designer getDesigner(@PathVariable("id") String id) {
		return service.getDesignerById(id);
	}
	
	@PostMapping("/designers")
	public ResponseEntity<Designer> createDesigner(@Validated @RequestBody Designer designer) {
		Designer savedDesigner = service.createDesigner(designer);
		//CREATED
		// /user/{id}    savedUser.getId()
		//URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedDesigner.getId()).toUri();
		return new ResponseEntity<Designer>(savedDesigner, HttpStatus.CREATED);
	}
	
	@PutMapping("designers/{id}")
	public ResponseEntity<Designer> updateDesigner(@Validated @RequestBody Designer designer, @PathVariable("id") String id){
		designer.setId(id);
		Designer designerUpdated = service.updateDesignerById(designer);
		if(designerUpdated != null) {
			return new ResponseEntity<Designer>(designerUpdated, HttpStatus.OK);
		}
		return new ResponseEntity<Designer>(HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("designers/{id_designer}/{id_boardGame}")
	public ResponseEntity<Designer> addBoardGame(@Validated @RequestBody Designer designer, @PathVariable("id_designer") String id_designer,
												 @Validated @RequestBody BoardGame boardgame, @PathVariable("id_boardGame") String id_boardGame){
				designer.setId(id_designer);
				boardgame.setId(id_boardGame);
				Designer designerAddBoardGame = service.addToDesignerNewBoardGame(designer, boardgame);
				if(designerAddBoardGame != null) {
					return new ResponseEntity<Designer>(designerAddBoardGame, HttpStatus.OK);
				}
				return new ResponseEntity<Designer>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("designers/{id}")
	public ResponseEntity<Designer> deleteDesigner(@PathVariable("id") String id){
		if(service.deleteDesignerById(id)) {
			return new ResponseEntity<Designer>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Designer>(HttpStatus.NOT_FOUND);
	}
}
