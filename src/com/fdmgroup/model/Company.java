package com.fdmgroup.model;


import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "JPA_COMPANY")
@NamedQueries({
	@NamedQuery(name = "company.findByName", query = "SELECT c FROM Company c WHERE c.name LIKE :cn"),
	@NamedQuery(name = "company.findByStockSymbol", query = "SELECT c FROM Company c WHERE c.stockSymbol = :cn"),
})

public class Company {

	@Id
	@SequenceGenerator(name = "companySequence", sequenceName="COMPANY_CUSTOM_SEQUENCE", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "companySequence")
	@Column(name = "company_id")
	private int id;
	
	@Column(name = "company_name")
	private String name;
	
	@Column(name="stockSymbol")
	private String stockSymbol;
	
	@Column(name="exchangeId")
	private int exchangeId;
	

	public Company() {
		super();
	}
	
	
	public Company( String name, String stockSymbol, int exchangeId) {
		super();
		this.name = name;
		this.stockSymbol = stockSymbol;
		this.exchangeId = exchangeId;
	}


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


	public void setExchangeId(int exchangeId) {
		this.exchangeId = exchangeId;
	}


	

	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", stockSymbol=" + stockSymbol + ", exchangeId=" + exchangeId
				+ "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Company other = (Company) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
