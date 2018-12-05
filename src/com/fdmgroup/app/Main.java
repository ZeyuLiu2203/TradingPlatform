package com.fdmgroup.app;

import com.fdmgroup.model.*;

import java.time.LocalDateTime;
import java.util.List;

import com.fdmgroup.dao.*;



public class Main {

	public static void main(String[] args) {
		UserDao userCollection= new UserDao();
		CompanyDao companydao = new CompanyDao();
		
		TradeDao td = new TradeDao();
		
		List<Trade> trades = td.getTradeByUserid(1);
		
		//User ret = userCollection.findById(1);
		//System.out.println(ret);
		//System.out.println(trades.size());
		
		User u = userCollection.findById(1);
		System.out.println(u);
		u.setEmail("nmsl");
		u.setUsername("????");
		u.setFirstname("bin");
		u.setLastname("sun");
		userCollection.update(u);
		
		System.out.println(userCollection.findById(1));
	}

}
