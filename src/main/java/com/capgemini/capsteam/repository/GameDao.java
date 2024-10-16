package com.capgemini.capsteam.repository;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.capgemini.capsteam.model.Game;


@Repository
public interface GameDao extends JpaRepository<Game,Integer>{

	/**
	 * Metodo para buscar el texto que se envía por parametros desde el buscador.
	 * Containing- para que coincida con cualquier parte del nombre del juego.
	 * IgnoreCase - no hace distinción entre mayúsculas y minúsculas.
	 */	
	
	List<Game> findByNameContainingIgnoreCase(String name);

	/**
	 * Método que busca y devuelve todos los juegos que coinciden con el año proporcionado.
	 * @param year, para filtrar los juegos en la base de datos que tienen ese año específico.
	 * @return Una lista de objetos `Game` que contiene todos los juegos filtrados por el año.
	 */
	List<Game> findByYear(int year);


}

