package model;

import java.time.LocalDateTime;

public class StockPrice implements IStorable {
	private int id;
	private double price;
	private LocalDateTime timestamp;

	public StockPrice() {
	}

	public StockPrice(double price, LocalDateTime timestamp) {
		super();
		this.price = price;
		this.timestamp = timestamp;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "StockPrice [id=" + id + ", price=" + price + ", timestamp=" + timestamp + "]";
	}

}
