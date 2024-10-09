package com.capgemini.capsteam.service;

import java.util.List;

import java.util.Optional;

import com.capgemini.capsteam.model.Game;

public interface GameService {
	
	//Metodo para obtener la lista de juegos
	public List<Game> findAll();
	
	// Save and update
	public void save(Game game);

	/**
	 * Declaracion metodo para eliminar una tupla de la base de datos a traves de su id
	 * @param rank : entero que sirve para identificar la entidad a borrar
	 */
	public void deleteById(int rank);
	
	public Optional<Game> findById(int rank);
}
