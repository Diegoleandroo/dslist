package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.repositories.GameRepository;

//Componentes de Sistemas 
// Service or Component -> Registra os componetes
@Service
public class GameService {
	
	//Componente que implementa lógica de negócio -> Regra que tem que acontecer)
	
	// Autowired -> Faz com que a Spring resolva essa dependência GameRepository
	
	@Autowired
	private GameRepository gameRepository;
	
	public List <GameMinDTO> findAll(){ // findAll -> Buscar todos
		
		 List <Game> result = gameRepository.findAll(); //Isso ja gera uma consulta do dados, que gerara todos os games
		 return result.stream().map(x -> new GameMinDTO(x)).toList();
	
		// retornando o resultado da chamada DTO 
		//Isso ja gera uma consulta do dados, que gerara todos os games
        // O resultado da consulta será convertida para uma tabela de game List <Game> result
		// stream -> Permite fazer uma operação com sequenciais de dados (map) sequencia para outra
		   
	}
	
}
