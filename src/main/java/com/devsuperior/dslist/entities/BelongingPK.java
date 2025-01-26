package com.devsuperior.dslist.entities;

import java.util.Objects;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
            // Encapsulando 2 atributos em uma classe só 
@Embeddable // Tenho a classe representando 2 campos,e vou colocar essa classe como um atributo 
            // de um outro tipo mapeado da JPA, que vai representar 2 campos na tabela do banco relacional
public class BelongingPK {

	//Configuração da JPA
	
	@ManyToOne // Muitos para Um
	@JoinColumn(name = "game_id") // Nome da chave estrageira. Isso será mapeado para 2 campos
	private Game game; // Chave Auxiliar
	
	@ManyToOne // Muitos para Um
	@JoinColumn(name = "list_id")
	private GameList list;
	
	
	public BelongingPK() {
		
		
	}


	public BelongingPK(Game game, GameList list) {
		
		this.game = game;
		this.list = list;
	}


	public Game getGame() {
		return game;
	}


	public void setGame(Game game) {
		this.game = game;
	}


	public GameList getList() {
		return list;
	}


	public void setList(GameList list) {
		this.list = list;
	}


	@Override
	public int hashCode() {
		return Objects.hash(game, list);
	}


	@Override
	public boolean equals(Object obj) { //Comparação 
										// -> chave Primaria multipla 
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BelongingPK other = (BelongingPK) obj;
		return Objects.equals(game, other.game) && Objects.equals(list, other.list);
	}
	
	
	
	
	
}
