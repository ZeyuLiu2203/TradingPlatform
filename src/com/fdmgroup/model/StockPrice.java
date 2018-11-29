package com.fdmgroup.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "Stockprice")
@NamedQueries({
	@NamedQuery(name = "stockprice.findByComanyid", query = "SELECT t FROM StockPrice t where t.companyid = :cn"),
	
})
public class StockPrice implements IStorable {
	@Id
	@Column(name = "stockprice_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name="price")
	private double price;
	
	@Column(name="companyid")
	private int companyid;
	
	@Column(name="time")
	private LocalDateTime timestamp;

	public StockPrice() {
	}

	public StockPrice(double price) {
		super();
		this.price = price;
		this.timestamp = LocalDateTime.now();
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
