package com.capgemini.capsteam;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.capsteam.model.Game;
import com.capgemini.capsteam.repository.GameDao;
@SpringBootTest
class TestAdd {

    @Autowired
    private GameDao gameDAO; // Inyección del GameDAO

    @Test
    public void testSaveGame_withValidGame() {
        Game game = new Game();
        game.setName("Mario Kart Wii");
        game.setPlatform("Wii");
        game.setYear(2008);
        game.setGenre("Racing");
        game.setPublisher("Nintendo");
        game.setNaSales(15.85);
        game.setEuSales(12.88);
        game.setJpSales(3.79);
        game.setOtherSales(3.31);
        game.setGlobalSales(35.82);

        Game savedGame = gameDAO.save(game); // Guardamos el juego

        // Verificamos que el juego guardado no sea nulo
        assertNotNull(savedGame, "El juego guardado debería no ser nulo");
        // Verificamos el nombre del juego
        assertEquals("Mario Kart Wii", savedGame.getName(), "El nombre del juego guardado no coincide");
    }
    @Test
    public void testSaveGame_withEmptyName() {
        Game game = new Game();
        game.setName(""); // Nombre vacío
        game.setPlatform("Wii");
        game.setYear(2008);
        game.setGenre("Racing");
        game.setPublisher("Nintendo");
        game.setNaSales(15.85);
        game.setEuSales(12.88);
        game.setJpSales(3.79);
        game.setOtherSales(3.31);
        game.setGlobalSales(35.82);

        try {
            gameDAO.save(game); // Intentamos guardar un juego con nombre vacío
            fail("Se esperaba una excepción al guardar un juego con nombre vacío"); // Fallar si no se lanza la excepción
        } catch (RuntimeException e) {
            String expectedMessage = "El nombre del juego no puede estar vacío"; // Asegúrate de que este mensaje sea el correcto
            String actualMessage = e.getMessage();
            assertEquals(expectedMessage, actualMessage, "El mensaje de error no coincide.");
        }
    }
}
