package com.devsuperior.dslist.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.projections.GameMinProjection;

public interface GameRepository extends JpaRepository<Game, Long>{

	// Essa anotação faz com que funcione a consulta SQL 
	@Query(nativeQuery = true, value = """ 
			SELECT tb_game.id, tb_game.title, tb_game.game_year AS `year`, tb_game.img_url AS imgUrl,
			tb_game.short_description AS shortDescription, tb_belonging.position
			FROM tb_game
			INNER JOIN tb_belonging ON tb_game.id = tb_belonging.game_id
			WHERE tb_belonging.list_id = :listId
			ORDER BY tb_belonging.position
				""")
	
	List<GameMinProjection> searchByList(Long listId); // O parametro que passar para o metodo vai passar na listId do banco de dados 
	

	// Consulta SQL Se coloca neste arquivo
	// 
	
	
	
	
	//Objeto responsável por fazer consulta ao Banco de Dados
	
	// JpaRepository fooi colocado o tipo da entidade que e GAME e o tipo 
	// do id que e LONG
	
	// So esses ccomando ja faz consultas com o banco, Criar, Atualizar, Deletar 
	
	
	
}
