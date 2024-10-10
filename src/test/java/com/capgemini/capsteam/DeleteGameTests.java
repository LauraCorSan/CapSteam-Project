package com.capgemini.capsteam;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.capgemini.capsteam.model.Game;
import com.capgemini.capsteam.repository.GameDao;
import com.capgemini.capsteam.service.GameServiceImpl;


@ExtendWith(MockitoExtension.class)
class DeleteGameTests {


	@Mock
	private GameDao gameDao; // Mockeamos el repositorio

	@InjectMocks
	private GameServiceImpl gameService; // Clase bajo prueba

	private Game game;

	@BeforeEach
	void setUp() {
		game = new Game(1, "Game1", "Platform1", 2020, "Genre1", "Publisher1", 1.5, 1.0, 0.5, 0.2, 3.2);
		// mockMvc = MockMvcBuilders.standaloneSetup(gameController).build();

	}

	/**
	 * Prueba unitaria para verificar el comportamiento correcto del método
	 * deleteById() del servicio GameServiceImpl.
	 */
	@Test
	void testDeleteEntity() {
		// Ejecutamos el método deleteEntity
		gameService.deleteById(game.getRank());

		// Verificamos que el método delete fue llamado en el repositorio
		verify(gameDao, times(1)).deleteById(game.getRank());

	}

}
