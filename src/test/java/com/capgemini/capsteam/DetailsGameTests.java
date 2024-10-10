package com.capgemini.capsteam;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.capgemini.capsteam.controller.GameController;
import com.capgemini.capsteam.model.Game;
import com.capgemini.capsteam.service.GameService;

@ExtendWith(MockitoExtension.class)
class DetailsGameTests {

	@Mock
	private GameService service;

	@InjectMocks
	private GameController gameController;

	@Autowired
	private MockMvc mockMvc;

	private Game game;

	@BeforeEach
	void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(gameController).build();
		game = new Game(1, "Game1", "Platform1", 2000, "Genre1", "Publisher1", 1.5, 1.0, 0.5, 0.2, 3.2);
	}

	// Prueba unitaria que simula que el servicio encuentra el juego correctamente
	@Test
	void testGameDetails() throws Exception {

		when(service.findById(1)).thenReturn(Optional.of(game));

		mockMvc.perform(get("/details?rank=1")).andExpect(status().isOk()).andExpect(model().attributeExists("game"))
				.andExpect(view().name("gameDetails.html"));
	}

	// Prueba unitaria que simula que el servicio no encuentra el juego, aunque a
	// pesar de ello la pagina carga
	@Test
	void testGameDetailsNotFound() throws Exception {

		when(service.findById(1)).thenReturn(Optional.empty());

		mockMvc.perform(get("/details?rank=1"))
				.andExpect(status().isOk())
				.andExpect(model().attributeDoesNotExist(game.getName())) // Verifica que no tiene atributos
				.andExpect(view().name("gameDetails.html"));
	}

}
