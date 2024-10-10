package com.capgemini.capsteam;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.capsteam.controller.GameController;
import com.capgemini.capsteam.model.Game;
import com.capgemini.capsteam.repository.GameDao;
import com.capgemini.capsteam.service.GameService;

@SpringBootTest
class ComponentExistsTest {
	@Autowired
	private GameService gameService;
	
	@Autowired
	private GameController gameController;

	@Autowired
	private GameDao gameDao;
	
	@Autowired
	private Game game;
	
	/**
	 * Comprueba que existe el servicio
	 */
	@Test
	void shouldExistService() {
		assertThat(gameService).isNotNull();
	}
	
	/**
	 * Comprueba que existe el controlador
	 */
	@Test
	void shouldExistController() {
		assertThat(gameController).isNotNull();
	}
	
	/**
	 * Comprueba que existe el repositorio
	 */
	@Test
	void shouldExistRepository() {
		assertThat(gameDao).isNotNull();
	}
	
	/**
	 * Comprueba que existe el modelo
	 */
	@Test
	void shouldExistModel() {
		assertThat(game).isNotNull();
	}
	
	
	

}
