package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dslist.dto.GameDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.projections.GameMinProjection;
import com.devsuperior.dslist.repositories.GameRepository;

import jakarta.transaction.Transactional;

//Componentes de Sistemas 
// Service or Component -> Registra os componetes
@Service
public class GameService {
	
	//Componente que implementa lógica de negócio -> Regra que tem que acontecer)
	
	// Autowired -> Faz com que a Spring resolva essa dependência GameRepository
	
	@Autowired
	private GameRepository gameRepository;
	
	@org.springframework.transaction.annotation.Transactional(readOnly = true)//Assegurando que não vou fazer nenhuma operação de escrita  
	public GameDTO findById(Long id) { // Método para buscar pelo ID
		
		Game result = gameRepository.findById(id).get();
		
		return new GameDTO(result);
		
	}
	
	@org.springframework.transaction.annotation.Transactional(readOnly = true)
	public List <GameMinDTO> findAll(){ // findAll -> Buscar todos
		
		 List <Game> result = gameRepository.findAll(); //Isso ja gera uma consulta do dados, que gerara todos os games
		 return result.stream().map(x -> new GameMinDTO(x)).toList();
	
		// retornando o resultado da chamada DTO 
		//Isso ja gera uma consulta do dados, que gerara todos os games
        // O resultado da consulta será convertida para uma tabela de game List <Game> result
		// stream -> Permite fazer uma operação com sequenciais de dados (map) sequencia para outra
		   
	}
	
	
	@org.springframework.transaction.annotation.Transactional(readOnly = true)
	public List <GameMinDTO> findByList(Long listId){ // findAll -> Buscar todos
		
		 List <GameMinProjection> result = gameRepository.searchByList(listId); //Isso ja gera uma consulta do dados, que gerara todos os games
		 return result.stream().map(x -> new GameMinDTO(x)).toList();
	
		// retornando o resultado da chamada DTO 
		//Isso ja gera uma consulta do dados, que gerara todos os games
        // O resultado da consulta será convertida para uma tabela de game List <Game> result
		// stream -> Permite fazer uma operação com sequenciais de dados (map) sequencia para outra
		   
	}
	
	
}
