package model;

import java.time.LocalDateTime;

public class Trade implements IStorable {
	private int id;
	private Company companyOwned;
	private User transactor;
	private double quantity;
	private LocalDateTime timebought;

	//TODO: optionally implement priceAtSale to keep track of price changes while owned and work out profit or loss in reports
	private double priceAtSale;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Company getCompanyOwned() {
		return companyOwned;
	}

	public void setCompanyOwned(Company companyOwned) {
		this.companyOwned = companyOwned;
	}
	

	public User getTransactor() {
		return transactor;
	}

	public void setTransactor(User transactor) {
		this.transactor = transactor;
	}

	public double getPriceAtSale() {
		return priceAtSale;
	}

	public void setPriceAtSale(double priceAtSale) {
		this.priceAtSale = priceAtSale;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public LocalDateTime getTimebought() {
		return timebought;
	}

	public void setTimebought(LocalDateTime timebought) {
		this.timebought = timebought;
	}

	@Override
	public String toString() {
		return "Trade [id=" + id + ", companyOwned=" + companyOwned + ", transactor=" + transactor + ", quantity="
				+ quantity + ", timebought=" + timebought + ", priceAtSale=" + priceAtSale + "]";
	}

}
