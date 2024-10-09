package com.capgemini.capsteam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capgemini.capsteam.model.Game;
import com.capgemini.capsteam.repository.GameDao;


@Service
public class GameServiceImpl implements GameService {
	
	GameDao gameDao;     // Inyección del DAO para acceder a la base de datos

	@Autowired
    public GameServiceImpl(GameDao gameDao) {
        this.gameDao = gameDao; // Inicializa el GameDao
    }


	
	 /**
     * Busca juegos en la base de datos que contengan el nombre proporcionado.
     * name El nombre del juego a buscar (puede ser parcial y no distingue mayúsculas/minúsculas).
     * Devuelve una lista de juegos que coinciden con el nombre proporcionado.
     */
	@Override
    public List<Game> getGameByName(String name) {

		return gameDao.findByNameContainingIgnoreCase(name);
	}

}