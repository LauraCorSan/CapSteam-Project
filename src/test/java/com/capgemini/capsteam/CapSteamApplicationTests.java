package com.capgemini.capsteam;

import static org.assertj.core.api.Assertions.assertThat;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.capsteam.controller.GameController;
import com.capgemini.capsteam.model.Game;
import com.capgemini.capsteam.repository.GameDaoImpl;

@SpringBootTest
class CapSteamApplicationTests {
	private GameDaoImpl GameDao;
	
	


@Autowired
private GameController controller;

@Test
void shouldExistsController() {
	assertThat(controller).isNotNull();
}
}