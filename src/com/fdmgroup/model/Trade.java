package com.fdmgroup.model;

import java.time.LocalDateTime;
import javax.persistence.*;


@Entity
@Table(name="trade")
@NamedQueries({
	@NamedQuery(name = "trade.findByUserid", query = "SELECT t FROM Trade t where t.userid = :cn"),
	
})
public class Trade implements IStorable {
	public Trade() {
		super();
	}

	@Id
	@Column(name = "trade_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name="companyid")
	private int companyid;
	
	@Column(name="userid")
	private int userid;
	
	@Column(name="quantity")
	private double quantity;
	
	@Column(name="timeBought")
	@Convert(converter = LocalDateTimeAttributeConverter.class)
	private LocalDateTime timebought;

	//TODO: optionally implement priceAtSale to keep track of price changes while owned and work out profit or loss in reports

	
	public int getId() {
		return id;
	}

	public Trade(int companyid, int userid, double quantity, LocalDateTime timebought) {
		super();

		this.companyid = companyid;
		this.userid = userid;
		this.quantity = quantity;
		this.timebought = timebought;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCompanyid() {
		return companyid;
	}

	public void setCompanyid(int id) {
		this.companyid = id;
	}
	public int getUser() {
		return userid;
	}

	public void setUserid(int id) {
		this.userid = id;
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
		return "Trade [id=" + id + ", companyOwned=" + companyid + ", user id=" + userid + ", quantity="
				+ quantity + ", timebought=" + timebought +  "]";
	}

}
