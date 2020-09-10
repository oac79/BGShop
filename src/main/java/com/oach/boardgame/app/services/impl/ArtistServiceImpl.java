package com.oach.boardgame.app.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oach.boardgame.app.models.Artist;
import com.oach.boardgame.app.repositories.IArtistRepository;
import com.oach.boardgame.app.services.IArtistService;

@Service
public class ArtistServiceImpl implements IArtistService {
	
	@Autowired
	IArtistRepository repository;
	
	@Override
	public Artist createArtist(Artist artist) {
		return repository.insert(artist);
	}

	@Override
	public List<Artist> getAllArtists() {
		return repository.findAll();
	}

	@Override
	public Artist getArtistById(String id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public Artist updateArtistById(Artist artist) {
		if(repository.existsById(artist.getId())) {
			return repository.save(artist);
		}
		return null;
	}

	@Override
	public boolean deleteArtistById(String id) {
		if(repository.existsById(id)) {
			repository.deleteById(id);
			return true;
		}
		return false;
	}

}
