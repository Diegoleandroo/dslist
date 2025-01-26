package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dslist.dto.GameListDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.GameList;
import com.devsuperior.dslist.repositories.GameListRepository;

//Componentes de Sistemas 
// Service or Component -> Registra os componetes
@Service
public class GameListService {
	
	//Componente que implementa lógica de negócio -> Regra que tem que acontecer)
	
	// Autowired -> Faz com que a Spring resolva essa dependência GameRepository
	
	@Autowired
	private GameListRepository gameListRepository;
	
	@org.springframework.transaction.annotation.Transactional(readOnly = true)
	public List <GameListDTO> findAll(){ // findAll -> Buscar todos
		
		 List <GameList> result = gameListRepository.findAll(); //Isso ja gera uma consulta do dados, que gerara todos os games
		 return result.stream().map(x -> new GameListDTO(x)).toList();
	
		// retornando o resultado da chamada DTO 
		//Isso ja gera uma consulta do dados, que gerara todos os games
        // O resultado da consulta será convertida para uma tabela de game List <Game> result
		// stream -> Permite fazer uma operação com sequenciais de dados (map) sequencia para outra
		   
	}
	
}
