package com.capgemini.capsteam.service;


import java.util.Optional;

import com.capgemini.capsteam.model.Game;


public interface GameService {
	
	// Save and update
	public void save(Game game);

	public void deleteById(int id);
	
	public Optional<Game> findById(int rank);
}
