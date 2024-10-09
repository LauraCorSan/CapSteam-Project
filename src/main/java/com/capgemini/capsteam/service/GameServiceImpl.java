package com.capgemini.capsteam.service;

import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capgemini.capsteam.model.Game;
import com.capgemini.capsteam.repository.GameDao;

@Service
public class GameServiceImpl implements GameService {

	@Autowired
	public GameDao gameDao;

	@Override
	public List<Game> findAll() {
		return gameDao.findAll();
	}

	/**
	 * Método para guardar y actualizar un juego
	 * @param game, el juego a guardar o actualizar
	 * @return void
	 */
	@Override
	public void save(Game game) {
		gameDao.save(game);
	}

	/**
	 * Metodo para eliminar una tupla de la base de datos a traves de su id. Llama
	 * al metodo del Repositorio (jpaRepository)
	 * 
	 * @param rank : entero que sirve para identificar la entidad a borrar
	 */
	@Override
	public void deleteById(int rank) {
		gameDao.deleteById(rank);
	}

	/**
	 * Método para encontrar un juego por id
	 * @param rank, el id único para identificar el juego
	 * @return Optional<Game>
	 */
	@Override
	public Optional<Game> findById(int rank) {
		return gameDao.findById(rank);
	}

}
