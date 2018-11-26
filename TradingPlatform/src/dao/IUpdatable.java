package dao;

import model.IStorable;

public interface IUpdatable<T extends IStorable> {
	boolean update(T t);

}
