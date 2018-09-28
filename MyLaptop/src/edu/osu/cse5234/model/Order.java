package edu.osu.cse5234.model;

import java.util.ArrayList;

public class Order {

	
	private String orderNumber = null;
	private ArrayList<Item> items=null;
	
	public Order() { }
	
	public String getOrderNumber() {
		return orderNumber;		
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	
	public ArrayList<Item> getItems() {
		return items;		
	}
	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}
}
