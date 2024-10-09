package com.capgemini.capsteam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.capgemini.capsteam.model.Game;
import com.capgemini.capsteam.service.GameService;

@Controller
@RequestMapping("/games")
public class GameController {
	
	
	// Inyección del servicio de juegos para acceder a la lógica de negocio
	@Autowired
	GameService service;
	
	/**
     * Maneja las solicitudes GET para buscar juegos. 
     * name: El nombre del juego a buscar. Si es null, no se realiza ninguna búsqueda.
     * m: El modelo para pasar atributos a la vista.
     * devuelve la vista html que se renderiza.
     */

	@GetMapping(path = {"/error", "/search"})
	    public String searchGameByName(@RequestParam(required = false) String name,Model m) {

		  System.out.println("Searching for: " + name); // Imprime el nombre buscado
		  
			if (name != null) {
			 List<Game> games = service.getGameByName(name);
			 System.out.println("Games found: " + games); // Imprimir los juegos encontrados
			 m.addAttribute("games", games);
			 m.addAttribute("name", name);
		 }
	       
		  return "search";
	    }
	
}
