package com.capgemini.capsteam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.capgemini.capsteam.model.Game;
import com.capgemini.capsteam.service.GameService;

@Controller
@RequestMapping("/games")
public class GameController {
	
	@Autowired
	GameService service;

	  @GetMapping("/search")
	    public List<Game> searchGameByName(@RequestParam String name) {
	        return service.getGameByName(name);
	    }
	
	
	


}
