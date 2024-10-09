package com.capgemini.capsteam.service;

import java.util.List;

import com.capgemini.capsteam.model.Game;

public interface GameService {
	
	 /**
     * Busca juegos por nombre.
     * Devuelve una lista de juegos que coinciden con el nombre proporcionado.
     */
	List<Game> getGameByName(String name);
	
	

}
