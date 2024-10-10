package com.capgemini.capsteam.model;

import java.io.Serializable;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;


@Entity
@Table(name = "game")
public class Game implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2255623775586100155L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Rank")
	private int rank;

	@NotEmpty
	@Column(name = "Name")
	private String name;

	@NotEmpty
	@Column(name = "Platform")
	private String platform;

	@NotEmpty
	@Size(min=4, max=4)
	@Column(name = "Year")
	private int year;

	@NotEmpty
	@Column(name = "Genre")
	private String genre;

	@NotEmpty
	@Column(name = "Publisher")
	private String publisher;

	@Column(name = "NA_Sales")
	private double naSales;

	@Column(name = "EU_Sales")
	private double euSales;

	@Column(name = "JP_Sales")
	private double jpSales;

	@Column(name = "Other_Sales")
	private double otherSales;

	@NotEmpty
	@Column(name = "Global_Sales")
	private double globalSales;


	
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
