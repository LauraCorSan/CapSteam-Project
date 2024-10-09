package com.capgemini.capsteam.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.capgemini.capsteam.model.Game;

import ch.qos.logback.core.model.Model;

public class GameController {
	@Autowired
	Game Service service;
	
	private static final Logger log = LoggerFactory.getLogger(GameController.class);
	
	//Nuevo Juego
		@GetMapping("/new")
		public String newUser(Game game, Model g) {
			g.addAttribute("game",game);
			return "GameForm";
		}
		
		//Guardar Usuario
		@PostMapping("/save")
		public String saveUser(Game game) {
			Service.save(game);
			return ("redirect:/");
		}
}
