package com.devsuperior.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dslist.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long>{

	
	//Objeto responsável por fazer consulta ao Banco de Dados
	
	// JpaRepository fooi colocado o tipo da entidade que e GAME e o tipo 
	// do id que e LONG
	
	// So esses ccomando ja faz consultas com o banco, Criar, Atualizar, Deletar 
	
	
	
}
