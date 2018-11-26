package dao.implemenmtation;

import java.util.List;

import dao.ICompanyDao;
import model.Company;
import model.User;

import javax.persistence.*;


public class CompanyDao implements ICompanyDao{
	
	private DbConnection connection;
	
	public CompanyDao() {
		super();
		connection = DbConnection.getInstance();
	}

	@Override
	public Company readById(int id) {
		EntityManager em = connection.getEntityManager();
		Company company = em.find(Company.class, id);
		em.close();
		return company;
	}

	@Override
	public List<Company> readAll() {
		EntityManager em = connection.getEntityManager();
		TypedQuery<Company> query = em.createNamedQuery("Company.findAll", Company.class);
		List<Company> companys = query.getResultList();
		em.close();
		return companys;
	}

	@Override
	public boolean create(Company t) {
		EntityManager em = connection.getEntityManager();
		em.getTransaction().begin();
		em.persist(t);
		em.getTransaction().commit();
		em.close();
		
		return true;
	}

	@Override
	public boolean update(Company company) {
		EntityManager em = connection.getEntityManager();
		Company foundCompany = em.find(Company.class, company.getId());
		em.getTransaction().begin();
		
		if (company.getName() != null && !company.getName().equals(""))
			foundCompany.setName(company.getName());
		
		em.getTransaction().commit();
		em.close();
		return true;
	}

	@Override
	public boolean delete(Company company) {
		EntityManager em = connection.getEntityManager();
		Company foundCompany = em.find(Company.class, company.getId());
		em.getTransaction().begin();
		em.remove(foundCompany);
		em.getTransaction().commit();
		em.close();
		return true;
		
	}

	@Override
	public Company readByName(String name) {
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
