/*
*@file_Name: LoginDaoImp.java
*@Author: Shwetali
*@Date: 28-09-2016
*@purpose: class for performing operations related to database.
*/
package com.bridgelabz.dao;

import java.util.List;
import javax.annotation.Resource;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.bridgelabz.dto.Login;

//@Repository("loginDao")
public class LoginDaoImp implements LoginDao {

	@Resource(name = "sessionFactory")
	SessionFactory sessionFactory;
	Session session;

	// checking user name and password
	public boolean isValid(String username, String password) {
		session = sessionFactory.openSession();

		Query query = session.createQuery("from Login where username=? and password=?");
		query.setString(0, username);
		query.setString(1, password);
		
		List list = query.list();
		if (list != null && list.size() > 0)
			return true;
		else
			return false;
	}

	// display list of user
	public List<Login> showList() {
		session = sessionFactory.openSession();
		Query query = session.createQuery("from Login");
		List<Login> list = query.list();
		for (Login login : list) {
			System.out.println("Dao:" + login.getUsername());
		}
		return list;
	}

	//register new user
	public String addUser(String username, String password) {
		System.out.println("name: "+username+" Password "+password);
		session = sessionFactory.openSession();
		Login login = new Login();
		login.setPassword(password);
		login.setUsername(username);
		session.save(login);
		
		System.out.println(login);
		return "success";
		
	}
	
}
