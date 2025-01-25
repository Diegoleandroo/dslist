package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.repositories.GameRepository;

//Componentes de Sistemas 
//Registrados os componetes
@Service
public class GameService {
	
	@Autowired
	private GameRepository gameRepository;
	
	public List <GameMinDTO> findAll(){ // findAll Buscar todos os games
		
		 List <Game> result = gameRepository.findAll();
		 return result.stream().map(x -> new GameMinDTO(x)).toList();
	
		 
	}
	
}
