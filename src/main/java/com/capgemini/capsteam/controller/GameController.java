package com.capgemini.capsteam.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.capgemini.capsteam.model.Game;
import com.capgemini.capsteam.service.GameService;


@Controller
public class GameController {
	@Autowired
	GameService service;
	
	private static final Logger log = LoggerFactory.getLogger(GameController.class);
	
		@GetMapping("/new")
		public String newUser(Game game, Model g) {
			g.addAttribute("game",game);
			return "GameForm";
		}
	@GetMapping("/games")
	public String listGames(Model m) {
		m.addAttribute("gameList",service.findAll());
	return "GameList.html";	
	}
		
	
	@GetMapping("/update")
	public String update(@RequestParam("rank") int rank, Model m) {
		//TODO check null
		m.addAttribute("game", service.findById(rank));
		return "gameFormUpdate.html";
		
	}
	
	@PostMapping("/save")
	public String save(Game game) {
		service.save(game);
		return ("redirect:/games");
		
	}


	@GetMapping("/delete")
	public String deleteGame(@RequestParam("rank") int rank) {
		service.deleteById(rank);
		return ("redirect:/games");
	}
}
