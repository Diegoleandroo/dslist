package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dslist.dto.GameListDTO;
import com.devsuperior.dslist.entities.GameList;
import com.devsuperior.dslist.projections.GameMinProjection;
import com.devsuperior.dslist.repositories.GameListRepository;
import com.devsuperior.dslist.repositories.GameRepository;

//Componentes de Sistemas 
// Service or Component -> Registra os componetes
@Service
public class GameListService {
	
	//Componente que implementa lógica de negócio -> Regra que tem que acontecer)
	
	// Autowired -> Faz com que a Spring resolva essa dependência GameRepository
	
	@Autowired
	private GameListRepository gameListRepository;
	
	@Autowired
	private GameRepository gameRepository;
	
	@org.springframework.transaction.annotation.Transactional(readOnly = true)
	public List <GameListDTO> findAll(){ // findAll -> Buscar todos
		
		 List <GameList> result = gameListRepository.findAll(); //Isso ja gera uma consulta do dados, que gerara todos os games
		 return result.stream().map(x -> new GameListDTO(x)).toList();
	
		// retornando o resultado da chamada DTO 
		//Isso ja gera uma consulta do dados, que gerara todos os games
        // O resultado da consulta será convertida para uma tabela de game List <Game> result
		// stream -> Permite fazer uma operação com sequenciais de dados (map) sequencia para outra
		   
	}
	
	@org.springframework.transaction.annotation.Transactional
	public void move(Long listId , int sourceIndex, int destinationIndex) {
		
		List <GameMinProjection> list = gameRepository.searchByList(listId);
		
		GameMinProjection obj = list.remove(sourceIndex);
		list.add(destinationIndex, obj);
		
		
		int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
		int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;
		
		
		for (int i = min; i <= max; i++) {
			
			gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
		
		}
		
		
		
		
		
	}
	
	
}
