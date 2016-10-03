/*
*@file_Name: Country.java
*@Author: Shwetali
*@Date: 01-10-2016
*@purpose: POGO class for Country
*/
package com.bridgelabz.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "COUNTRY")
public class Country {

	@Id
	@GeneratedValue//for autogenerating the id value
	@Column(name = "CTRY_ID")
	private Integer id;

	@Column(name = "CTRY_NAME")
	private String name;

	@Column(name = "CTRY_AREA")
	private Integer area;

	@Column(name = "CTRY_POP")
	private Long population;

	@Column(name = "POP_UPD_ON")
	private Date populationLastUpdated;

	@Column(name = "CURRENCY")
	private String currency;

	//default constructor for country class
	public Country() {
	}

	//parametrise constructor
	public Country(Integer id, String name, Integer area, Long population, Date populationLastUpdated,
			String currency) {
		setId(id);
		setName(name);
		setArea(area);
		setPopulation(population);
		setPopulationLastUpdated(populationLastUpdated);
		setCurrency(currency);
	}

	//getters and setters
	public boolean isNew() {
		return id == null;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setArea(Integer area) {
		this.area = area;
	}

	public Integer getArea() {
		return area;
	}

	public void setPopulation(Long population) {
		this.population = population;
	}

	public Long getPopulation() {
		return population;
	}

	public void setPopulationLastUpdated(Date populationLastUpdated) {
		this.populationLastUpdated = populationLastUpdated;
	}

	public Date getPopulationLastUpdated() {
		return populationLastUpdated;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getCurrency() {
		return currency;
	}

}