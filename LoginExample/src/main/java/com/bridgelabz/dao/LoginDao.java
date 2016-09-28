/*
*@file_Name: LoginDao.java
*@Author: Shwetali
*@Date: 28-09-2016
*@purpose: Interface LoginDao
*/
package com.bridgelabz.dao;

import java.util.List;

import com.bridgelabz.dto.Login;

public interface LoginDao {
	public boolean isValid(String username, String password);

	public List<Login> showList();

	public String addUser(String username, String password);
}
