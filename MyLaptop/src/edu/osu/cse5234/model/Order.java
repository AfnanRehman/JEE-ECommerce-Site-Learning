package edu.osu.cse5234.model;

import java.util.ArrayList;

import edu.osu.cse5234.business.view.Item;

public class Order {

	
	private String orderNumber = null;
	private ArrayList<Item> items=null;
	private String confirmed = null;
	public Order() { }
	public void confirm(String code) {
		confirmed = code;
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
