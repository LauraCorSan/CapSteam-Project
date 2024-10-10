package com.capgemini.capsteam.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.capgemini.capsteam.model.Game;
import com.capgemini.capsteam.service.GameService;

@Controller
public class GameController {
	
	
	private static final Logger log = LoggerFactory.getLogger(GameController.class);
	// Inyección del servicio de juegos para acceder a la lógica de negocio
	@Autowired
	GameService service;
	
//	/**
//     * Maneja las solicitudes GET para buscar juegos. 
//     * @param name: El nombre del juego a buscar. Si es null, no se realiza ninguna búsqueda.
//     * @param m: El modelo para pasar atributos a la vista.
//     * @return devuelve la vista html que se renderiza.
//     */
//
//	@GetMapping(path = {"/games/error", "/games/search"})
//	    public String searchGameByName(@RequestParam(required = false) String name,Model m) {
//
//		  System.out.println("Searching for: " + name); // Imprime el nombre buscado
//		  
//			if (name != null) {
//			 List<Game> games = service.getGameByName(name);
//			 System.out.println("Games found: " + games); // Imprimir los juegos encontrados
//			 m.addAttribute("games", games);
//			 m.addAttribute("name", name);
//		 }
//	       
//		  return "gameSearch.html";
//	    }
//	

	
	@GetMapping("/new")
	public String newUser(Game game, Model g) {
		g.addAttribute("game",game);
		return "gameFormCreate.html";
	}

	/**
	 * Método para listar todos los juegos.	  
	 * @param m parameto para añadir atributos al model
	 * @return nombre del archivo de la vista HTML
	 */

	@GetMapping("/games")
	public String listGames(Model m) {
		m.addAttribute("gameList", service.findAll());
		return "gameList";
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
	
	
//	/**
//     * Maneja las solicitudes GET para buscar juegos filtraados por años. 
//     * @param year: El año del juego a buscar. Si es null, no se realiza ninguna búsqueda.
//     * @param m: El modelo para pasar atributos a la vista.
//     * @return devuelve la vista html que se renderiza.
//     */
//	@GetMapping("/games/searchYear")
//	public String searchGameByYear(@RequestParam (required = false) Integer year, Model m) {
//		 System.out.println("Searching for: " + year); // Imprime el nombre buscado
//		 
//		 if (year != null) {
//			 List<Game> games = service.findByYear(year);
//			 System.out.println("Games found: " + games); // Imprimir los juegos encontrados
//			 m.addAttribute("games", games);
//			 m.addAttribute("year", year);
//		 }
//		return "gameSearchYear.html";
//		
//	}
	
	/**
	 * Maneja las solicitudes GET para buscar juegos filtrados por nombre y/o año.
	 * Este método recibe parámetros opcionales para realizar una búsqueda por nombre, por año o por ambos.
	 * Si ambos parámetros son nulos, se muestra un mensaje indicando que no se encontraron resultados.
	 * 
	 * @param name: El nombre del juego a buscar. Si es null o está vacío, no se realiza búsqueda por nombre.
	 * @param year: El año del juego a buscar. Si es null, no se realiza búsqueda por año.
	 * @param m: El modelo para pasar los atributos a la vista.

	 * @return Devuelve la vista "gameSearch.html", que se renderiza con los resultados de la búsqueda o un mensaje vacío.
	 */
	@GetMapping("/games/search")
	public String searchGame(
	    @RequestParam(required = false) String name,
	    @RequestParam(required = false) Integer year, 
	    Model m) {
	    
	    System.out.println("Searching for: Name = " + name + ", Year = " + year); 

	    // Si se proporciona el nombre, buscar por nombre
	    if (name != null && !name.isEmpty()) {
	        List<Game> gamesByName = service.getGameByName(name);
	        m.addAttribute("games", gamesByName);
	        m.addAttribute("name", name);
	    }

	    // Si se proporciona el año, buscar por año
	    if (year != null) {
	        List<Game> gamesByYear = service.findByYear(year);
	        m.addAttribute("games", gamesByYear);
	        m.addAttribute("year", year);
	    }

	    // Si no se proporciona ninguno de los dos, devolver un mensaje vacío o todos los juegos
	    if (name == null && year == null) {
	        m.addAttribute("message", "No se encontraron resultados para la búsqueda.");
	    }

	    return "gameSearch.html"; 
	}

	
	
	
	
}


