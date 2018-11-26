package model;

import java.time.LocalDateTime;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;



@Entity
@Table(name="company")
@NamedQueries({
	@NamedQuery(name = "company.findByName", query = "SELECT c FROM Company c WHERE c.name LIKE :cn"),
	@NamedQuery(name = "company.findByStockSymbol", query = "SELECT c FROM Company c WHERE c.stockSymbol LIKE :cn"),
	@NamedQuery(name = "company.findAll", query = "SELECT c FROM Company c"),
})
public class Company implements IStorable {
	
	@Id
	@Column(name="companyid")
	private int id;
	
	@Column(name="companyName")
	private String name;
	
	@Column(name="stockSymbol")
	private String stockSymbol;
	
	@Column(name="exchangeId")
	private int exchangeId;
	
	
	private List<StockPrice> priceHistory;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStockSymbol() {
		return stockSymbol;
	}

	public void setStockSymbol(String stockSymbol) {
		this.stockSymbol = stockSymbol;
	}

	public int getExchangeId() {
		return exchangeId;
	}

	public void setExchange(int exchangeId) {
		this.exchangeId = exchangeId;
	}

	public List<StockPrice> getPriceHistory() {
		return priceHistory;
	}

	public void setNewPrice(double price) {
		if (this.priceHistory == null)
			this.priceHistory = new ArrayList<>();

		this.priceHistory.add(new StockPrice(price, LocalDateTime.now()));
	}

	public void setPriceHistory(List<StockPrice> priceHistory) {
		this.priceHistory = priceHistory;
	}

	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", stockSymbol=" + stockSymbol + ", exchangeId=" + exchangeId
				+ ", priceHistory=" + priceHistory + "]";
	}

}
