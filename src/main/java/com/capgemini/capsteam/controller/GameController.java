package com.capgemini.capsteam.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.capgemini.capsteam.service.GameService;

@Controller
@RequestMapping("/game")
public class GameController {

	@Autowired
	GameService service;

	private static final Logger log = LoggerFactory.getLogger(GameController.class);

	@GetMapping("/delete")
	public String deleteGame(@RequestParam("rank") int rank) {
		service.deleteById(rank);
		return ("redirect:/");
	}
}
