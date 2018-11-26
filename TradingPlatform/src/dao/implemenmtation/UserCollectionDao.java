package dao.implemenmtation;

import java.util.*;


import dao.IUserDao;
import model.User;


import javax.persistence.*;


public class UserCollectionDao implements IUserDao {


	private IdGenerator idGen = new IdGenerator();
	private List<User> users = new ArrayList<>();
	
	private EntityManagerFactory emf; 
	private EntityManager em = null;
	private EntityTransaction et = null;
	private DbConnection connection;
	
	public UserCollectionDao(IdGenerator idGen, List<User> users, EntityManagerFactory emf) {
		super();
		this.idGen = idGen;
		this.users = users;
		this.emf = Persistence.createEntityManagerFactory("tpuser");
	}
	
	@Override
	public boolean create(User t) {
		EntityManager em = connection.getEntityManager();
		em.getTransaction().begin();
		em.persist(t);
		em.getTransaction().commit();
		em.close();
		
		return true;
	}
	@Override
	public User readById(int id) {
		EntityManager em = connection.getEntityManager();
		User user = em.find(User.class, id);
		em.close();
		return user;
	}
	
	
	@Override
	public boolean update(User user) {
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
		
		return true;
	}
	@Override
	public boolean delete(User t) {
		EntityManager em = connection.getEntityManager();
		User foundUser = em.find(User.class, t.getId());
		em.getTransaction().begin();
		em.remove(foundUser);
		em.getTransaction().commit();
		em.close();
		
		return true;
	}
	@Override
	public User readByUsername(String username) {
		EntityManager em = connection.getEntityManager();
		User user = em.find(User.class, username);
		em.close();
		return user;
	}
	@Override
	public User readByEmail(String email) {
		EntityManager em = connection.getEntityManager();
		User user = em.find(User.class, email);
		em.close();
		return user;
	}
	@Override
	public List<User> readAll() {
		EntityManager em = connection.getEntityManager();
		TypedQuery<User> query = em.createNamedQuery("user.findAll", User.class);
		List<User> users = query.getResultList();
		em.close();
		return users;
	}
	
	

}
