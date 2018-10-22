package edu.osu.cse5234.model;

import java.io.Serializable;

public class Item implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 9114872907196583964L;
	private String name = null;
	private String price = null;
	private String quantity = null;

	public Item() { }
	
	public String getName() {
		return name;		
	}
	
	public String getPrice() {
		return price;
	}
	
	public String getQuantity() {
		return quantity;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
}
