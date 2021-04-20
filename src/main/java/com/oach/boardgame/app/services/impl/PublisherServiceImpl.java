package com.oach.boardgame.app.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oach.boardgame.app.models.Publisher;
import com.oach.boardgame.app.repositories.IPublisherRepository;
import com.oach.boardgame.app.services.IPublisherService;

@Service
public class PublisherServiceImpl implements IPublisherService {
	
	@Autowired
	private IPublisherRepository repository;

	@Override
	public Publisher createPublisher(Publisher publisher) {
		return repository.insert(publisher);
	}

	@Override
	public List<Publisher> getAllPublisher() {
		return repository.findAll();
	}

	@Override
	public Publisher getPublisherById(String id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public Publisher updatePublisherById(Publisher publisher) {
		if(repository.existsById(publisher.getId())) {
			return repository.save(publisher);
		}
		return null;
	}

	@Override
	public boolean deletePublisherById(String id) {
		if(repository.existsById(id)) {
			repository.deleteById(id);
			return true;
		}
		return false;
	}

}
