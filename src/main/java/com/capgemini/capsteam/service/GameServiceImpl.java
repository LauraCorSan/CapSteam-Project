package com.capgemini.capsteam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.capsteam.repository.GameDao;

@Service
public class GameServiceImpl implements GameService {
	
	@Autowired
	GameDao gameDAO;

	@Override
	public void deleteById(int id) {
		gameDAO.deleteById(id);
	}

}
