package com.capgemini.capsteam.service;

import java.util.List;

import com.capgemini.capsteam.model.Game;

public interface GameService {
	
	// Buscar juego por nombre
	List<Game> getGameByName(String name);
	
	

}
