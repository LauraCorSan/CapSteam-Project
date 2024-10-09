package com.capgemini.capsteam.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.capgemini.capsteam.model.Game;
import com.capgemini.capsteam.service.GameService;

@Controller
public class GameController {
	@Autowired
	GameService service;

	private static final Logger log = LoggerFactory.getLogger(GameController.class);

	// Listar games
	@GetMapping("/games")
	public String listGames(Model m) {
		m.addAttribute("gameList", service.findAll());
		return "GameList.html";
	}

	@GetMapping("/update")
	public String update(@RequestParam("rank") int rank, Model m) {
		// TODO check null
		m.addAttribute("game", service.findById(rank));
		return "gameFormUpdate.html";
	}

	@PostMapping("/save")
	public String save(Game game) {
		service.save(game);
		return ("redirect:/games");
	}

	/**
	 * Metodo para eliminar una tupla de la base de datos a traves de su id (que es
	 * el rank) una vez realizada la operacion en la capa de servicio redirige a /games (pagina principal)
	 * 
	 * @param rank : entero que sirve para identificar la entidad a borrar
	 * @return string que redirige a games
	 */
	@GetMapping("/delete")
	public String deleteGame(@RequestParam("rank") int rank) {
		service.deleteById(rank);
		return ("redirect:/games");
	}
}
