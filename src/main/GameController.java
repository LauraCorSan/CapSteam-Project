package com.capgemini.capsteam.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.capsteam.repository.GameDao;

@RestController
@RequestMapping("/game")
public class GameController {
private GameDao gameDao=new GameDaoImpl();
@PostMapping("/save")
public boolean saveGame(Game game) {
	service.save(game);
	return ("redirect:/");
}
}
