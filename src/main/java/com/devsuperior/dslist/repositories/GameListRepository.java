package com.devsuperior.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.dslist.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long>{

	
	@Modifying
	@Query(nativeQuery = true, 
	value = "UPDATE tb_belonging SET position = :newPosition WHERE list_id = :listId AND game_id = :gameId")
	void updateBelongingPosition(Long listId, Long gameId, Integer newPosition);
	
	//Objeto responsável por fazer consulta ao Banco de Dados
	
	// JpaRepository fooi colocado o tipo da entidade que e GAME e o tipo 
	// do id que e LONG
	
	// So esses ccomando ja faz consultas com o banco, Criar, Atualizar, Deletar 
	
	
	
}
