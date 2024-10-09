package com.capgemini.capsteam.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.capgemini.capsteam.model.Game;
import com.capgemini.capsteam.service.GameService;

@Controller
@RequestMapping("/game")
public class GameController {
	
	@Autowired
	public GameService gameService;
	
	private static final Logger log = LoggerFactory.getLogger(GameController.class);
	
	
	@GetMapping("/update")
	public String update(@RequestParam("rank") int rank, Model m) {
		//TODO check null
		m.addAttribute("game", gameService.findById(rank));
		return "gameFormUpdate";
		
	}
	
	@PostMapping("/save")
	public String save(Game game) {
		gameService.save(game);
		return ("redirect:/");
		
	}
	


}
