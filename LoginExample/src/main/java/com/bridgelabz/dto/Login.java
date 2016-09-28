/*
*@file_Name: Login.java
*@Author: Shwetali
*@Date: 28-09-2016
*@purpose: dto class for storing user info.
*/
package com.bridgelabz.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table
public class Login {
	@Id
	@GeneratedValue
	private int id;
	
	@NotEmpty(message="please enter username")
	@Column
	private String username;
	
	/*@Size(min=3,max=8,message="Not valid size")*/
	@NotEmpty(message="please enter password")
	@Column
	private String password;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
