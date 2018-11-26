package dao;

import java.util.List;

import model.IStorable;

public interface IReadable<T extends IStorable> {

	T readById(int id);

	List<T> readAll();

}
