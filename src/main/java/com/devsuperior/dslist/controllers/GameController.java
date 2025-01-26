package com.devsuperior.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dslist.dto.GameDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.services.GameService;

//Essa classe vai disponibilizar o API 

@RestController 
@RequestMapping(value = "/games") //Configurado o caminho que será correspondido chamando a API
public class GameController {
	
	// O controller injeta o  Service
	@Autowired 
	private GameService gameService; 
	
	
	@GetMapping(value = "/{id}") // Configurando que terá um parametro ID nesta composição 
	public GameDTO findById(@PathVariable Long id){ // O método rebera um argumento, essa anotação 
		                                            // permitira o acesso  
		GameDTO result = gameService.findById(id);
		return result;
	}
	
	
	
	
	@GetMapping // Verbo HTTP (GetMapping-> Buscar)
	public List<GameMinDTO> findAll(){
		
		List<GameMinDTO> result = gameService.findAll();
		return result;
	}
	

}
