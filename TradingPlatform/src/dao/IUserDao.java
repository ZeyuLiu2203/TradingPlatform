package dao;

import model.User;

public interface IUserDao extends ICreatable<User>, IReadable<User>, IUpdatable<User>, IDeletable<User> {

	User readByUsername(String username);

	User readByEmail(String email);


}
