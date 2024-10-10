package com.capgemini.capsteam.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "game")
public class Game {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Rank")
	private int rank;

	@NotBlank(message = "El nombre no puede estar vacío")
	@Column(name = "Name")
	private String name;

	@NotBlank(message = "La plataforma no puede estar vacía")
	@Column(name = "Platform")
	private String platform;

	@Min(value = 1950, message = "El año debe ser mayor o igual a 1950")
	@Column(name = "Year")
	private int year;

	@NotBlank(message = "El género no puede estar vacío")
	@Column(name = "Genre")
	private String genre;

	@NotBlank(message = "El editor no puede estar vacío")
	@Column(name = "Publisher")
	private String publisher;

	@DecimalMin("0.0")
	@Column(name = "NA_Sales")
	private Double naSales;

	@DecimalMin("0.0")
	@Column(name = "EU_Sales")
	private Double euSales;

	@DecimalMin("0.0")
	@Column(name = "JP_Sales")
	private Double jpSales;

	@DecimalMin("0.0")
	@Column(name = "Other_Sales")
	private Double otherSales;

	@DecimalMin("0.0")
	@Column(name = "Global_Sales")
	private Double globalSales;

	public Game(int rank, String name, String platform, int year, String genre, String publisher, double naSales,
			double euSales, double jpSales, double otherSales, double globalSales) {
		super();
		this.rank = rank;
		this.name = name;
		this.platform = platform;
		this.year = year;
		this.genre = genre;
		this.publisher = publisher;
		this.naSales = naSales;
		this.euSales = euSales;
		this.jpSales = jpSales;
		this.otherSales = otherSales;
		this.globalSales = globalSales;
	}

	public Game() {
		super();
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public double getNaSales() {
		return naSales;
	}

	public void setNaSales(double naSales) {
		this.naSales = naSales;
	}

	public double getEuSales() {
		return euSales;
	}

	public void setEuSales(double euSales) {
		this.euSales = euSales;
	}

	public double getJpSales() {
		return jpSales;
	}

	public void setJpSales(double jpSales) {
		this.jpSales = jpSales;
	}

	public double getOtherSales() {
		return otherSales;
	}

	public void setOtherSales(double otherSales) {
		this.otherSales = otherSales;
	}

	public double getGlobalSales() {
		return globalSales;
	}

	public void setGlobalSales(double globalSales) {
		this.globalSales = globalSales;
	}

	@Override
	public String toString() {
		return "Game [rank=" + rank + ", name=" + name + ", platform=" + platform + ", year=" + year + ", genre="
				+ genre + ", publisher=" + publisher + ", naSales=" + naSales + ", euSales=" + euSales + ", jpSales="
				+ jpSales + ", otherSales=" + otherSales + ", globalSales=" + globalSales + "]";
	}

}
