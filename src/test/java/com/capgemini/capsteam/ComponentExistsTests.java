package com.capgemini.capsteam;

import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.capsteam.controller.GameController;
import com.capgemini.capsteam.repository.GameDao;
import com.capgemini.capsteam.service.GameService;

@SpringBootTest
class ComponentExistsTests {
	@Autowired
	private GameService gameService;
	
	@Autowired
	private GameController gameController;
 
	@Autowired
	private GameDao gameDao;
	
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
 
}