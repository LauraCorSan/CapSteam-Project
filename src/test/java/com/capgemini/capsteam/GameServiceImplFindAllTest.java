package com.capgemini.capsteam;

import com.capgemini.capsteam.model.Game;
import com.capgemini.capsteam.repository.GameDao;
import com.capgemini.capsteam.service.GameServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)  //línea para habilitar la extensión de Mockito, si no da error
class GameServiceImplFindAllTest {

    @Mock
    private GameDao gameDao;  //mockeamos el repositorio

    @InjectMocks
    private GameServiceImpl gameService;  //clase bajo prueba

    private Game game1;
    private Game game2;

    @BeforeEach
    void setUp() {
        game1 = new Game(1, "Game1", "Platform1", 2020, "Genre1", "Publisher1", 1.5, 1.0, 0.5, 0.2, 3.2);
        game2 = new Game(2, "Game2", "Platform2", 2021, "Genre2", "Publisher2", 2.0, 1.2, 0.8, 0.4, 4.4);
    }

    
    /**
     * Prueba unitaria para verificar el comportamiento del método findAll() 
     * del servicio GameServiceImpl. Simula la respuesta del repositorio 
     * (GameDao) utilizando Mockito y valida que la lista de juegos 
     * devuelta contenga los juegos esperados.
     */
    @Test
    void testFindAll() {
        //simulamos la respuesta del repositorio
        List<Game> games = Arrays.asList(game1, game2);
        when(gameDao.findAll()).thenReturn(games);  // Simulamos que findAll devuelve los juegos. Poner null para que falle

        List<Game> result = gameService.findAll();

        //verificamos que la respuesta sea la esperada
        assertNotNull(result);  
        assertEquals(2, result.size());  
        assertEquals("Game1", result.get(0).getName());  
        assertEquals("Game2", result.get(1).getName());  

        verify(gameDao, times(1)).findAll();  
    }
}
