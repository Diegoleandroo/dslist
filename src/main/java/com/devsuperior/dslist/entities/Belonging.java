package com.devsuperior.dslist.entities;

import java.util.Objects;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_belonging") // Criando a tabela
public class Belonging {
	// Encapsulando 2 atributos em uma classe só 
	
	@EmbeddedId
	private BelongingPK id = new BelongingPK(); // Chave Auxiliar REPRESENTAR UMA CHAVE PRIMAR MULTIPLA
	
	private Integer position;
	
	public Belonging() {
		
	}

	public Belonging(Game game, GameList list, Integer position) {
		
		id.setGame(game); // Associamos o game e list com a classe Belonging
		id.setList(list);
		
		this.position = position;
	}

	public BelongingPK getId() {
		return id;
	}

	public void setId(BelongingPK id) {
		this.id = id;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) { // Irá comparar belonging pelo belongiing pelo id   
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Belonging other = (Belonging) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
}
