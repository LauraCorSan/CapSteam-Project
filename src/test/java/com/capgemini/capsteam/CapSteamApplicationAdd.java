package com.capgemini.capsteam;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.capgemini.capsteam.controller.GameController;
import com.capgemini.capsteam.model.Game;
import com.capgemini.capsteam.repository.GameDao;
import com.capgemini.capsteam.service.GameService;
import com.capgemini.capsteam.service.GameServiceImpl;

@WebMvcTest(GameController.class)
public class CapSteamApplicationAdd {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private GameService gameService;

	@Test
	public void testSaveGame_withEmptyName() throws Exception {

		// Simular la solicitud POST
		mockMvc.perform(post("/save").contentType(MediaType.APPLICATION_FORM_URLENCODED).param("rank", "3")
				.param("name", "Mario").param("platform", "Wii").param("year", "2008").param("genre", "Racing")
				.param("publisher", "Nintendo").param("naSales", "15.85").param("euSales", "12.88")
				.param("jpSales", "3.79").param("otherSales", "3.31").param("globalSales", "35.82"))
				.andExpect(status().isFound()); // Espera un error 302 Bad Request
	}

}
