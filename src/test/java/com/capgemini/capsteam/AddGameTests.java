package com.capgemini.capsteam;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.capgemini.capsteam.controller.GameController;
import com.capgemini.capsteam.service.GameService;

@WebMvcTest(GameController.class)
public class AddGameTests {
 
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
 