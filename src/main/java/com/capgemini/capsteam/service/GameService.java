package com.capgemini.capsteam.service;

import java.util.List;

import com.capgemini.capsteam.model.Game;

public interface GameService {
	
	/**
	 * Método para obtener la lista de todos los juegos.
	 */
	public List<Game> findAll();

}
