package com.capgemini.capsteam;

import static org.junit.jupiter.api.Assertions.assertNull;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.capsteam.model.Game;
import com.capgemini.capsteam.repository.GameDao;

import jakarta.transaction.Transactional;

@SpringBootTest
class CapSteamApplicationAdd {
	@Autowired
    private GameDao gameDAO; // Inyección del GameDAO

    @BeforeEach
    public void setUp() {
        // Si es necesario, puedes limpiar la base de datos aquí o preparar datos
    }

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
        Game savedGame = gameDAO.save(game); // Intentamos guardar el juego con nombre vacío

        // Aquí esperamos que el juego no se guarde, así que verificamos que el objeto guardado sea nulo
        assertNull(savedGame); // Debería ser nulo si el juego no se guardó correctamente
    }

    @Test
    @Transactional
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
        Game savedGame = gameDAO.save(game); // Guardamos el juego
        // Verificamos que el juego guardado no sea nulo
        assertNotNull(savedGame); // Debería devolver el objeto guardado
    }
}