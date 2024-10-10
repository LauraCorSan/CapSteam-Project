package com.capgemini.capsteam;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

import com.capgemini.capsteam.controller.GameController;
import com.capgemini.capsteam.model.Game;
import com.capgemini.capsteam.service.GameService;

@ExtendWith(MockitoExtension.class)
public class GetGameByYearTests {

	@Mock
	private GameService service;

	@Mock
	private Model model;

	@InjectMocks
	private GameController controller;

	/**
	 * Este test simula que una busqueda tiene atributos correctos y que el nombre
	 * de la vista sea correcto
	 */
	@Test
	public void testSearchGameByYear_withYear() {

		Game game1 = new Game();
		game1.setYear(2005);

		Game game2 = new Game();
		game2.setYear(2006);

		List<Game> mockGames = Arrays.asList(game1, game2);

		when(service.findByYear(2005)).thenReturn(mockGames);
		String viewName = controller.searchGame(null, 2005, model);

		verify(model).addAttribute("games", mockGames);
		verify(model).addAttribute("year", 2005);

		assertEquals("gameSearch.html", viewName);
	}

	/**
	 * Este test simula que una búsqueda con un año vacío no se pueda hacer
	 */
	@Test
	public void testSearchGameByYear_withoutYear() {

		String viewName = controller.searchGame(null, null, model);

		verify(service, never()).findByYear(0);

		assertEquals("gameSearch.html", viewName);
	}


}
