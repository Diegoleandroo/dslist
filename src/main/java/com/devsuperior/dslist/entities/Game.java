package com.devsuperior.dslist.entities;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity //Configurar a classe java que sera equivalente a uma tabela do banco relacional 
@Table(name ="tb_game")   
public class Game {
	
	@Id// Id será chave Primária
	@GeneratedValue(strategy= GenerationType.IDENTITY) // Que seja autoimplentado para o banco de dados
	
	@Column(name = "id", nullable = false)
	private Long id;
	@Column(name = "title", nullable = false)
	private String title;
	
	// Year por ser uma palavra reservada do sql no banco de dados,poderá causar conflito
	@Column(name= "game_year" ,nullable = false) //Está Contumizando, pois mudará o nome quando for criar no banco de dados
	
	private Integer year;
	@Column(name = "genre", nullable = false)
	private String genre;
	
	@Column(name = "platform", nullable = false)
	private String platform;
	
	 @Column(name = "img_url", nullable = false)
	private String imgUrl;
	
	  @Column(name = "short_description", nullable = false, length = 255) 
	private String shortDescription;
	
	  @Column(name = "long_description", nullable = false, length = 255)  
	private String longDescription;
	
	
	
	public Game() {
		
	}



	public Game(Long id, String title, Integer year, String genre, String platform, String imgUrl, String shortDescription,
			String longDescription) {
		super();
		this.id = id;
		this.title = title;
		this.year = year;
		this.genre = genre;
		this.platform = platform;
		this.imgUrl = imgUrl;
		this.shortDescription = shortDescription;
		this.longDescription = longDescription;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public Integer getYear() {
		return year;
	}



	public void setYear(Integer year) {
		this.year = year;
	}
	
	
	public String getGenre() {
		
		return genre;
		
	}
	
	
	public void setGenre(String genre ) {
		
		this.genre = genre;
		
	}
	


	public String getPlatform() {
		return platform;
	}



	public void setPlatform(String platform) {
		this.platform = platform;
	}



	public String getImgUrl() {
		return imgUrl;
	}



	public void setImUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}



	public String getShortDescription() {
		return shortDescription;
	}



	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}



	public String getLongDescription() {
		return longDescription;
	}



	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}



	@Override
	public int hashCode() { //Metodos para comparar se são iguais ou não
		return Objects.hash(id);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Game other = (Game) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
	
	
	

}
