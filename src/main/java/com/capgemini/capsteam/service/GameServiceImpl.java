package com.capgemini.capsteam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.capsteam.model.Game;
import com.capgemini.capsteam.repository.GameDao;

@Service
public class GameServiceImpl implements GameService{
	
	@Autowired
	public GameDao gameDao;


	@Override
	public void save(Game game) {
		gameDao.save(game);
	}

}
