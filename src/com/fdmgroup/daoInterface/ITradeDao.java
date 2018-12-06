package com.fdmgroup.daoInterface;

import java.util.List;

import com.fdmgroup.model.Trade;
import com.fdmgroup.model.User;



public interface ITradeDao {
	List<Trade> getTradeByUserid(int userid);
	
	Trade create(Trade t);

	List<Trade> findAll();
}
