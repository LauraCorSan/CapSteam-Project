package com.capgemini.capsteam.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.capgemini.capsteam.service.GameService;

@Controller
public class GameController {
	@Autowired
	GameService service;
	
	
	/**
	 * Método para listar todos los juegos.	  
	 * @param m parameto para añadir atributos al model
	 * @return nombre del archivo de la vista HTML
	 */
	@GetMapping("/")
	public String listGames(Model m) {
		m.addAttribute("gameList",service.findAll());
		
		return "GameList.html";
	}
	

}
