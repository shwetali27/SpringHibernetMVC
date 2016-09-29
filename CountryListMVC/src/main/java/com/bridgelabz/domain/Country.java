/*
*@file_Name: Country.java
*@Author: Shwetali
*@Date: 29-09-2016
*@purpose: POGO class for Country Data.
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

	public Country() {
	}

	//constructor
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
