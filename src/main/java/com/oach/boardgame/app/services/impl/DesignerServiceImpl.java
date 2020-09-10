package com.oach.boardgame.app.services.impl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oach.boardgame.app.models.Designer;
import com.oach.boardgame.app.repositories.IDesignerRepository;
import com.oach.boardgame.app.services.IDesignerService;

@Service
public class DesignerServiceImpl implements IDesignerService {
	
	private static List<Designer> designers = new ArrayList<>();
	
	static 
	{
		designers.add(new Designer("001", "Jan", "Oldman"));
		designers.add(new Designer("002", "Mark", "Math"));
	}

	@Autowired
	private IDesignerRepository repository;

	@Override
	public Designer createDesigner(Designer designer) {
		return repository.insert(designer);
	}

	@Override
	public List<Designer> getAllDesigners() {
		return repository.findAll();
		//return designers;
	}

	@Override
	public Designer getDesignerById(String id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public Designer updateDesignerById(Designer designer) {
		if (repository.existsById(designer.getId())) {
			return repository.save(designer);
		}
		return null;
	}

	@Override
	public boolean deleteDesignerById(String id) {
		if(repository.existsById(id)) {
			repository.deleteById(id);
			return true;
		}
		return false;
	}

}
