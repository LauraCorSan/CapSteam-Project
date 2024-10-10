package com.capgemini.capsteam;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.capsteam.repository.GameDaoImpl;

@SpringBootTest
class CapSteamApplicationTests {


	@Test
	void shouldBeAlwaysTrue() {
		assertThat(true).isTrue();
	}
	
	
	
}