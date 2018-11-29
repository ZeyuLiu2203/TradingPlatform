package com.fdmgroup.app;

import com.fdmgroup.model.*;

import java.time.LocalDateTime;

import com.fdmgroup.dao.*;



public class Main {

	public static void main(String[] args) {
		UserDao userCollection= new UserDao();
		CompanyDao companydao = new CompanyDao();
		com.fdmgroup.model.User u1 = new User("www","123","jone","doe","eeee@qq.com");
		Company com=new Company("fdm","fdm",2);
		userCollection.create(u1);
		//userCollection.remove(u1);
		//companydao.create(com);
//		
//		TradeDao tradeDao = new TradeDao();
//		LocalDateTime localDateTime  = LocalDateTime.now();
//		
//		Trade t = new Trade(2,3,2.0,localDateTime);
//		
//		tradeDao.create(t);
		
		
	}

}
