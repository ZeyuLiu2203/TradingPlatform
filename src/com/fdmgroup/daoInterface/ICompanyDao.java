package com.fdmgroup.daoInterface;

import com.fdmgroup.model.Company;

public interface ICompanyDao {

	Company findByName(String name);
	Company readByStockSymbol(String name);
	Company create(Company company);
	 void remove(Company company);
	 void update(Company company);
	 Company findById(int id);
	
}
