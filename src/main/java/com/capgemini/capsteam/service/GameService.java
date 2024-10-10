package com.capgemini.capsteam.service;

import java.util.List;

import java.util.Optional;

import com.capgemini.capsteam.model.Game;

import java.util.List;

import com.capgemini.capsteam.model.Game;

public interface GameService {
	

	 /**
     * Busca juegos por nombre.
     * Devuelve una lista de juegos que coinciden con el nombre proporcionado.
     */
	List<Game> getGameByName(String name);
	
	

	/**
	 * Método para obtener la lista de todos los juegos.
	 */
	public List<Game> findAll();
	
	/**
	 * Método para guardar y actualizar un juego
	 * @param game, el juego a guardar o actualizar
	 * @return void
	 */
	public void save(Game game);

	/**
	 * Declaracion metodo para eliminar una tupla de la base de datos a traves de su id
	 * @param rank : entero que sirve para identificar la entidad a borrar
	 */
	public void deleteById(int rank);
	
	/**
	 * Método para encontrar un juego por id
	 * @param rank, el id único para identificar el juego
	 * @return Optional<Game>
	 */
	public Optional<Game> findById(int rank);
	
	
	/**
	 * Método que busca y devuelve todos los juegos que coinciden con el año proporcionado.
	 * @param year, para filtrar los juegos en la base de datos que tienen ese año específico.
	 * @return Una lista de objetos `Game` que contiene todos los juegos filtrados por el año.
	 */
	public List<Game>findByYear(int year);
}
