package com.fdmgroup.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.fdmgroup.daoInterface.ITradeDao;
import com.fdmgroup.model.Company;
import com.fdmgroup.model.Trade;

public class TradeDao implements ITradeDao{
	
	private DbConnection connection;
	
	public TradeDao() {
		super();
		connection = DbConnection.getInstance();
	}
	
	@Override
	public List<Trade> getTradeByUserid(int userid) {
		EntityManager em = connection.getEntityManager();
		TypedQuery<Trade> query = em.createNamedQuery("trade.findByUserid", Trade.class);
		query.setParameter("cn", userid);
		List<Trade> trades = query.getResultList();
		em.close();
		
		return trades;
	}

	@Override
	public Trade create(Trade t) {
		EntityManager em = connection.getEntityManager();
		em.getTransaction().begin();
		em.persist(t);
		em.getTransaction().commit();
		em.close();
		
		return t;
	}

}
