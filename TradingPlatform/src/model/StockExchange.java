package model;

public class StockExchange implements IStorable {

	private int id;
	private String name;
	private Currency currency;
	private String symbol;

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

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	@Override
	public String toString() {
		return "StockExchange [id=" + id + ", name=" + name + ", currency=" + currency + ", symbol=" + symbol + "]";
	}

}
