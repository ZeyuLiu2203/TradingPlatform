package com.fdmgroup.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.fdmgroup.daoInterface.IUserDao;
import com.fdmgroup.model.User;

public class UserDao implements IUserDao{

	private DbConnection connection;

	public UserDao() {
		super();
		connection = DbConnection.getInstance();
	}
	
	public User create(User user){
		EntityManager em = connection.getEntityManager();
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
		em.close();
		
		return user;
	}
	
	public void remove(User user){
		EntityManager em = connection.getEntityManager();
		User foundUser = em.find(User.class, user.getId());
		em.getTransaction().begin();
		em.remove(foundUser);
		em.getTransaction().commit();
		em.close();
	}
	
	public void update(User user){
		EntityManager em = connection.getEntityManager();
		User foundUser = em.find(User.class, user.getId());
		em.getTransaction().begin();
		
		if (user.getPassword() != null && !user.getPassword().equals(""))
			foundUser.setPassword(user.getPassword());
		if (user.getFirstname() != null && !user.getFirstname().equals(""))
			foundUser.setFirstname(user.getFirstname());
		if (user.getLastname() != null && !user.getLastname().equals(""))
			foundUser.setLastname(user.getLastname());

		em.getTransaction().commit();
		em.close();
	}
	
	public User findById(int id) {
		EntityManager em = connection.getEntityManager();
		User user = em.find(User.class, id);
		em.close();
		return user;
	}
	
	public List<User> findAll() {
		EntityManager em = connection.getEntityManager();
		TypedQuery<User> query = em.createNamedQuery("user.findAll", User.class);
		List<User> users = query.getResultList();
		em.close();
		return users;
	}
	
	
	public User findByUsername(String username) {
		EntityManager em = connection.getEntityManager();
		TypedQuery<User> query = em.createNamedQuery("user.findByUsername", User.class);
		query.setParameter("uname", username) ;
		List<User> users = query.getResultList();
		em.close();
		if (users != null && users.size() == 1){
			return users.get(0);
		}
		
		return null;
	}
	
	@Override
	public User readByEmail(String email) {
		EntityManager em = connection.getEntityManager();
		TypedQuery<User> query = em.createNamedQuery("user.findByUsername", User.class);
		query.setParameter("uname", email);
		List<User> users = query.getResultList();
		em.close();
		if (users != null && users.size() == 1){
			return users.get(0);
		}
		
		return null;
	}
}