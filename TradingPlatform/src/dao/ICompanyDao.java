package dao;

import model.Company;

public interface ICompanyDao extends IReadable<Company>, ICreatable<Company>, IUpdatable<Company>, IDeletable<Company> {

	Company readByName(String name);
	Company readByStockSymbol(String name);
	
}
