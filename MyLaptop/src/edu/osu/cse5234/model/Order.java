package edu.osu.cse5234.model;

import java.util.ArrayList;

public class Order {
	private String orderNumber = null;
	private ArrayList<Item> itemList=null;
	
	public Order() { }
	
	public String getOrderNumber() {
		return orderNumber;		
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	
	public ArrayList<Item> getItemList() {
		return itemList;		
	}
	public void setItemList(ArrayList<Item> itemList) {
		this.itemList = itemList;
	}
}
