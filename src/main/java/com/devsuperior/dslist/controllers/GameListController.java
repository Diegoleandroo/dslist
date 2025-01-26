package com.devsuperior.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dslist.dto.GameListDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.services.GameListService;
import com.devsuperior.dslist.services.GameService;

//Essa classe vai disponibilizar o API 

@RestController 
@RequestMapping(value = "/lists") //Configurado o caminho que será correspondido chamando a API
public class GameListController {
	
	// O controller injeta o  Service
	@Autowired 
	private GameListService gameListService; 
	
	@Autowired
	private GameService gameService;
	
		
	
	@GetMapping // Verbo HTTP (GetMapping-> Buscar)
	public List<GameListDTO> findAll(){
		List<GameListDTO> result = gameListService.findAll();
		return result;
	}
	
	
	@GetMapping(value = "/{listId}/games") // Verbo HTTP (GetMapping-> Buscar)
	public List<GameMinDTO> findByList(@PathVariable  Long listId){
		
		List<GameMinDTO> result = gameService.findByList(listId);
		return result;
	}
	

	

}
