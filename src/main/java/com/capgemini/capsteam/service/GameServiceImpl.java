package com.capgemini.capsteam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.capsteam.model.Game;
import com.capgemini.capsteam.repository.GameDao;

@Service
public class GameServiceImpl implements GameService{

	@Autowired
	GameDao gameDAO;
	
	//Para Listar Todos
	@Override
	public List<Game> findAll() {
		return gameDAO.findAll();
	}

	

}
