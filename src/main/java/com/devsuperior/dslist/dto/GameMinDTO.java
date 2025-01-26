package com.devsuperior.dslist.dto;

import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.projections.GameMinProjection;

public class GameMinDTO {

	// Versão do game, mas com so mente 5 dados

	private Long id;
	private String title;
	private Integer year;
	private String imgUrl;
	private String shortDescription;

	// Objeto responsável por fazer consulta no banco de dados

	public GameMinDTO() {

	}

	public GameMinDTO(Game entity) { // Quer dizer que o construtor recebe as entidades, instanciando a classe
										// Game

		id = entity.getId(); // Argummentos
		title = entity.getTitle();
		year = entity.getYear();
		imgUrl = entity.getImgUrl();
		shortDescription = entity.getShortDescription();
	}

	public GameMinDTO(GameMinProjection projection) { // Quer dizer que o construtor recebe as entidades, instanciando a classe
		// Game

		id = projection.getId(); // Argummentos
		title = projection.getTitle();
		year = projection.getYear();
		imgUrl = projection.getImgUrl();
		shortDescription = projection.getShortDescription();
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public Integer getYear() {
		return year;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public String getShortDescription() {
		return shortDescription;
	}

}
