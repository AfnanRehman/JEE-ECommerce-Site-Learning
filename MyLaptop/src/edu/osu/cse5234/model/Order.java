package edu.osu.cse5234.model;

import java.util.List;

public class Order {

	
	private String orderNumber = null;
	private List<Item> items=null;
	public Order() { }
	public String getOrderNumber() {
		return orderNumber;		
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	
	public List<Item> getItems() {
		return items;		
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
}
