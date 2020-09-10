package com.oach.boardgame.app.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oach.boardgame.app.models.Artist;
import com.oach.boardgame.app.repositories.IArtistRepository;
import com.oach.boardgame.app.services.IArtistService;

@Service
public class ArtistServiceImpl implements IArtistService {
	
	private static List<Artist> artists = new ArrayList<>();
	
	static 
	{
		artists.add(new Artist("art001", "Markus","Klein"));
		artists.add(new Artist("art002", "Raymond","Clerk"));
		artists.add(new Artist("art003", "Steve","Land"));
	}

	@Autowired
	IArtistRepository repository;
	
	@Override
	public Artist createDesigner(Artist artist) {
		// TODO Auto-generated method stub
		return repository.insert(artist);
	}

	@Override
	public List<Artist> getAllArtist() {
		//return repository.findAll();
		return artists;
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
