package model;

import java.util.ArrayList;

public class Portfolio implements IStorable{
	
	private int userid;	
	private ArrayList<Trade> stocks;

	public Portfolio() {
		super();
		stocks = new ArrayList<>();
		
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public ArrayList<Trade> getStocks() {
		return stocks;
	}

	public void setStocks(ArrayList<Trade> stocks) {
		this.stocks = stocks;
	}
	
	
	
	
	
	
	
	
}
