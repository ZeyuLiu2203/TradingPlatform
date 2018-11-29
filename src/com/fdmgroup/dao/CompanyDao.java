package com.fdmgroup.dao;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.fdmgroup.daoInterface.ICompanyDao;
import com.fdmgroup.model.Company;

public class CompanyDao implements ICompanyDao{

	private DbConnection connection;
	
	public CompanyDao() {
		super();
		connection = DbConnection.getInstance();
	}

	public Company create(Company company){
		EntityManager em = connection.getEntityManager();
		em.getTransaction().begin();
		em.persist(company);
		em.getTransaction().commit();
		em.close();
		
		return company;
	}
	
	public void remove(Company company){
		EntityManager em = connection.getEntityManager();
		Company foundCompany = em.find(Company.class, company.getId());
		em.getTransaction().begin();
		em.remove(foundCompany);
		em.getTransaction().commit();
		em.close();
	}
	
	public void update(Company company){
		EntityManager em = connection.getEntityManager();
		Company foundCompany = em.find(Company.class, company.getId());
		em.getTransaction().begin();
		
		if (company.getName() != null && !company.getName().equals(""))
			foundCompany.setName(company.getName());
		
		em.getTransaction().commit();
		em.close();
	}
	
	public Company findById(int id) {
		EntityManager em = connection.getEntityManager();
		Company company = em.find(Company.class, id);
		em.close();
		return company;
	}
	
	public Company findByName(String name) {
		EntityManager em = connection.getEntityManager();
		TypedQuery<Company> query = em.createNamedQuery("company.findByName", Company.class);
		query.setParameter("cn", name + "%");
		List<Company> companies = query.getResultList();
		em.close();
		
		return companies.get(0);
	}

	@Override
	public Company readByStockSymbol(String name) {
		EntityManager em = connection.getEntityManager();
		TypedQuery<Company> query = em.createNamedQuery("company.findByStockSymbol", Company.class);
		query.setParameter("cn", name + "%");
		List<Company> companies = query.getResultList();
		em.close();
		
		return companies.get(0);
	}
	
	
	
}