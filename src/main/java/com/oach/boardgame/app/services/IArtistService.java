package com.oach.boardgame.app.services;

import java.util.List;

import com.oach.boardgame.app.models.Artist;

public interface IArtistService {

	Artist createDesigner(Artist artist);
	
	List<Artist> getAllArtist();
	
	Artist getArtistById(String id);
	
	Artist updateArtistById(Artist artist);
	
	boolean deleteArtistById(String id);
}
