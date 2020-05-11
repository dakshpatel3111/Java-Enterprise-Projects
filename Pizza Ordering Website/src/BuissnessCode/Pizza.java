package BuissnessCode;

import java.sql.Timestamp;

//Run FrontDoor.java Project to start the Project 

public class Pizza {

	private String size;
	private String toppings;
	private double price;
	private java.sql.Timestamp sqldate;
	private String sqltime;
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	
	public Pizza() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Pizza(String size, String toppings, double price, Timestamp sqldate, String sqltime) {
		super();
		this.size = size;
		this.toppings = toppings;
		this.price = price;
		this.sqldate = sqldate;
		this.sqltime = sqltime;
	}
	public String getToppings() {
		return toppings;
	}
	public void setToppings(String toppings) {
		this.toppings = toppings;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public java.sql.Timestamp getSqldate() {
		return sqldate;
	}
	public void setSqldate(java.sql.Timestamp sqldate) {
		this.sqldate = sqldate;
	}
	public String getSqltime() {
		return sqltime;
	}
	public void setSqltime(String sqltime) {
		this.sqltime = sqltime;
	}
}
