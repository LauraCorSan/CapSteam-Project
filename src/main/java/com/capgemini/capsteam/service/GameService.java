package com.capgemini.capsteam.service;

import java.util.List;

import java.util.Optional;

import com.capgemini.capsteam.model.Game;

public interface GameService {
	
	//Metodo para obtener la lista de juegos
	public List<Game> findAll();
	
	// Save and update
	public void save(Game game);

	public void deleteById(int id);
	
	public Optional<Game> findById(int rank);
}
