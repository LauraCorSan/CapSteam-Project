package com.capgemini.capsteam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capgemini.capsteam.model.Game;
import com.capgemini.capsteam.repository.GameDao;


@Service
public class GameServiceImpl implements GameService {
	
	GameDao gameDao;
	@Autowired
    public GameServiceImpl(GameDao gameDao) {
        this.gameDao = gameDao;
    }


	@Override
    public List<Game> getGameByName(String name) {

		return gameDao.findByNameContainingIgnoreCase(name);
	}

}
