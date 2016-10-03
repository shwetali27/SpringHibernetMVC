/*
*@file_Name: Country.java
*@Author: Shwetali
*@Date: 28-09-2016
*@purpose: POJO class for Storing data.
*/

package com.bridgelabz.domain;

import java.util.Date;

public class Country {

	private Integer id;
	private String name;
	private Integer area;
	private Long population;
	private Date populationLastUpdated;
	private String currency;

	//default construstor
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