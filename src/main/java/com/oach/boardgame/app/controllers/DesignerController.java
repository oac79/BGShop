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


import com.oach.boardgame.app.models.Designer;
import com.oach.boardgame.app.services.IDesignerService;

@RestController
@RequestMapping("/api-designer")
public class DesignerController {

	@Autowired
	private IDesignerService service;
	
	@GetMapping("/designers")
	public List<Designer> getAllDesigners(){
		return service.getAllDesigners();
	}
	
	@GetMapping("/designer-id/{id}")
	public Designer getDesigner(@PathVariable("id") String id) {
		return service.getDesignerById(id);
	}
	
	@PostMapping("/designer")
	public ResponseEntity<Designer> createDesigner(@Validated @RequestBody Designer designer) {
		Designer savedDesigner = service.createDesigner(designer);
		//CREATED
		// /user/{id}    savedUser.getId()
		//URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedDesigner.getId()).toUri();
		return new ResponseEntity<Designer>(savedDesigner, HttpStatus.CREATED);
	}
	
	@PutMapping("designer-id/{id}")
	public ResponseEntity<Designer> updateDesignerById(@Validated @RequestBody Designer designer, @PathVariable("id") String id){
		designer.setId(id);
		Designer designerUpdated = service.updateDesignerById(designer);
		if(designerUpdated != null) {
			return new ResponseEntity<Designer>(designerUpdated, HttpStatus.OK);
		}
		return new ResponseEntity<Designer>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("designer-id/{id}")
	public ResponseEntity<Designer> deleteDesignerById(@PathVariable("id") String id){
		if(service.deleteDesignerById(id)) {
			return new ResponseEntity<Designer>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Designer>(HttpStatus.NOT_FOUND);
	}
}