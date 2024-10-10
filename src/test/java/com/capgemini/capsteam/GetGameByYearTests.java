package com.capgemini.capsteam;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

import com.capgemini.capsteam.controller.GameController;
import com.capgemini.capsteam.model.Game;
import com.capgemini.capsteam.service.GameService;

@ExtendWith(MockitoExtension.class) 
public class GetGameByYearTests {

    @Mock
    private GameService service; 

    @Mock
    private Model model; 

    @InjectMocks
    private GameController controller; 
    
    
    @Test
    public void testSearchGameByYear_withYear() {  
        
        Game game1 = new Game();
        game1.setYear(2005);

        Game game2 = new Game();
        game2.setYear(2006);

        List<Game> mockGames = Arrays.asList(game1, game2);

        when(service.findByYear(2005)).thenReturn(mockGames);
        String viewName = controller.searchGame(null, 2005, model);

        // Verificar que el modelo tiene los atributos correctos
        verify(model).addAttribute("games", mockGames);
        verify(model).addAttribute("year", 2005);

        // Verificar que el nombre de la vista es el correcto
        assertEquals("gameSearch.html", viewName);
    }

    @Test
    	// Simular una búsqueda con una cadena vacía
    public void testSearchGameByYear_withoutYear() {
       
        String viewName = controller.searchGame(null, null, model);

        verify(service, never()).findByYear(0);

        assertEquals("gameSearch.html", viewName);
    }
    
    @Test
    public void testSearchGameByYear() {
        
        int year = 2005;

        String viewName = controller.searchGame(null ,year, model);

        assertEquals("gameSearch.html", viewName);


    }

}
