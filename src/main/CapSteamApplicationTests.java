package com.capgemini.capsteam;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.capsteam.model.Game;
import com.capgemini.capsteam.repository.GameDaoImpl;
/*

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;*//*

public class DAOGameImplTest {
   
}
*/
@SpringBootTest
class CapSteamApplicationTests {
	private GameDaoImpl GameDao;
	@Before
	 public void setUp() {
        GameDao = new GameDaoImpl();
    }
	@Test
    public void testSaveGame_successful() {
        Game game = new Game();
        game.setName("WWE 2k24");
        game.setPlatform("Ps5");
        game.setReleaseYear("2024");
        game.setGenre("Fighting");
        game.setDeveloper("Sony");
        game.setNaSales("11.85");
        game.setEuSales("24.88");
        game.setJpSales("25.79");
        game.setOtherSales("1.31");
        game.setGlobalSales("63.83");
        
        boolean result = GameDao.saveGame(game);
        assertTrue(result);
    }
//TEST NO EXISTE UN PARAMETRO
    @Test
    public void testSaveGame_missingParameters() {
        Game game = new Game();
        game.setName(""); 
        game.setPlatform("Wii");
        game.setReleaseYear("2008");
        game.setGenre("Racing");
        game.setDeveloper("Nintendo");
        game.setNaSales("15.85");
        game.setEuSales("12.88");
        game.setJpSales("3.79");
        game.setOtherSales("3.31");
        game.setGlobalSales("35.82");
        boolean result = GameDao.saveGame(game);
        assertFalse(result); 
    }
//FECHA FORMATO INCORRECTO
    @Test
    public void testSaveGame_invalidDate() {
        Game game = new Game();
        game.setName("Test Game");
        game.setDeveloper("Test Developer");
        game.setReleaseDate("09-10-2030"); // Fecha en formato incorrecto

        boolean result = GameDao.saveGame(game);
        assertFalse(result); // Debería fallar por un formato de fecha incorrecto
    }
	}

}
