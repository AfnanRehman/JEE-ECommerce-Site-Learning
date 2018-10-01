package edu.osu.cse5234.model;

import java.util.ArrayList;

public class Order {

	
	private String orderNumber = null;
	private ArrayList<Item> items=null;
	private boolean confirmed = false;
	public Order() { }
	public void confirm() {
		confirmed = true;
	}
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
