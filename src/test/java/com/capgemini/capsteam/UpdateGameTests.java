package com.capgemini.capsteam;

import  org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.capgemini.capsteam.controller.GameController;
import com.capgemini.capsteam.model.Game;
import com.capgemini.capsteam.service.GameService;

@WebMvcTest(GameController.class)
public class UpdateGameTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GameService gameService;

    /**
     * Test que verifica que se muestran mensajes de error cuando se envían datos incompletos.
     */
    @Test
    @DisplayName("Guardar Juego - Campos Vacíos Deberían Retornar Errores de Validación")
    public void guardarJuego_CamposVacios_DeberiaRetornarErrores() throws Exception {
        mockMvc.perform(post("/save")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("rank", "1")
                .param("name", "") 
                .param("platform", "")
                .param("year", "2020")
                .param("genre", "Acción")
                .param("publisher", "Ubisoft")
                .param("naSales", "4.7")
                .param("euSales", "10.5")
                .param("jpSales", "5.0")
                .param("otherSales", "2.5")
                .param("globalSales", "18.0")
        )
        .andExpect(status().isOk())
        .andExpect(view().name("gameFormUpdate.html")) 
        .andExpect(model().attributeHasFieldErrors("game", "name", "platform"))
        .andExpect(model().attributeHasFieldErrorCode("game", "name", "NotBlank"))
        .andExpect(model().attributeHasFieldErrorCode("game", "platform", "NotBlank"));
    }

    /**
     * Test que verifica que se muestran mensajes de error cuando se envían datos incorrectos.
     */
    @Test
    @DisplayName("Guardar Juego - Datos Incorrectos Deberían Retornar Errores de Validación")
    public void guardarJuego_DatosIncorrectos_DeberiaRetornarErrores() throws Exception {
        mockMvc.perform(post("/save")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("rank", "2")
                .param("name", "Juego Test")
                .param("platform", "Console")
                .param("year", "1940") 
                .param("genre", "Estrategia")
                .param("publisher", "EA")
                .param("naSales", "15.0")
                .param("euSales", "-5.0")
                .param("jpSales", "3.0")
                .param("otherSales", "1.0")
                .param("globalSales", "19.0")
        )
        .andExpect(status().isOk())
        .andExpect(view().name("gameFormUpdate.html")) 
        .andExpect(model().attributeHasFieldErrors("game", "year", "euSales")) 
        .andExpect(model().attributeHasFieldErrorCode("game", "year", "Min"));
    }

    /**
     * Test que verifica que una solicitud válida redirige correctamente.
     */
    @Test
    @DisplayName("Guardar Juego - Datos Válidos Deberían Guardarse y Redirigir")
    public void guardarJuego_DatosValidos_DeberiaGuardarYRedirigir() throws Exception {

        mockMvc.perform(post("/save")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("rank", "3")
                .param("name", "Juego Válido")
                .param("platform", "NES")
                .param("year", "2021")
                .param("genre", "Puzzle")
                .param("publisher", "Activision")
                .param("naSales", "20.0")
                .param("euSales", "25.0")
                .param("jpSales", "10.0")
                .param("otherSales", "5.0")
                .param("globalSales", "60.0")
        )
        .andExpect(status().is3xxRedirection())
        .andExpect(redirectedUrl("/games")); 
    }
}
