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

	/**
	 * Método para listar todos los juegos.	  
	 * @param m parameto para añadir atributos al model
	 * @return nombre del archivo de la vista HTML
	 */

	@GetMapping("/games")
	public String listGames(Model m) {
		m.addAttribute("gameList", service.findAll());
		return "GameList.html";
	}
	
	/**
	 * Método para abrir el formulario y actualizar un juego
	 * @param rank: para identificar el juego
	 * @param m: el objeto Model para añadir atributos
	 * @return String del formulario html
	 */

	@GetMapping("/update")
	public String update(@RequestParam("rank") int rank, Model m) {
		m.addAttribute("game", service.findById(rank));
		return "gameFormUpdate.html";
	}
	
	/**
	 * Método para guardar un juego nuevo o actualizado, mostrarlo en el listado
	 * @param game, el juego a guardar o actualizar
	 * @return String que redirige a /games
	 */

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
	 * @return string que redirige a /games
	 */
	@GetMapping("/delete")
	public String deleteGame(@RequestParam("rank") int rank) {
		service.deleteById(rank);
		return ("redirect:/games");
	}
}
