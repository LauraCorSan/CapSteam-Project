package com.capgemini.capsteam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.capsteam.model.Game;


@Repository
public interface GameDao extends JpaRepository<Game, Integer>{

}
