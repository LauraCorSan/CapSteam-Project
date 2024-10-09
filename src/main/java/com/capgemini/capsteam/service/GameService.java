package com.capgemini.capsteam.service;

import java.util.List;

import com.capgemini.capsteam.model.Game;

public interface GameService {
	
	//Metodo para obtener la lista de juegos
	public List<Game> findAll();

}
