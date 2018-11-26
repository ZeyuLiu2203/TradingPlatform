package dao;

import java.util.List;

import model.Company;
import model.Trade;
import model.User;

public interface IPortfolioDao extends IReadable<Trade>, ICreatable<Trade> {

	List<Trade> getTradesByUser(User user);
	List<Trade> getTradesByCompany(Company company);
	
	
}
