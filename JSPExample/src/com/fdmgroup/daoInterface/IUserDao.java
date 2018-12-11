package com.fdmgroup.daoInterface;

import java.util.List;

import com.fdmgroup.model.User;

public interface IUserDao {

	User findByUsername(String username);

	User readByEmail(String email);
	
	List<User> findAll();
	
	User findById(int id);
	
	void update(User user);
	
	void remove(User user);
	
	User create(User user);


}
