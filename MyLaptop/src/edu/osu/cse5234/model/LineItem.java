package edu.osu.cse5234.model;

import javax.persistence.*;


@Entity
@Table(name="CUSTOMER_ORDER_LINE_ITEM")
public class LineItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	@Column(name="ITEM_NUMBER")
	private int itemNumber;
	@Column(name="ITEM_NAME")
	private String itemName;
	@Transient
	private double price;
	@Column(name="QUANTITY")
	private int quantity;
	
	
	public LineItem() {}
	public LineItem(Item item) {
		this.itemNumber=item.getItemNo();
		this.quantity=0;
		this.itemName=item.getName();
		this.price=item.getPrice();
	}
	

	public int getItemNumber() {
		return itemNumber;
	}
	public void setItemNumber(int itemNumber) {
		this.itemNumber = itemNumber;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	
	public Item getItem(){
		Item item=new Item();
		item.setItemNo(this.itemNumber);
		item.setName(this.itemName);
		item.setPrice(this.price);
		item.setQuantity(this.quantity);
		return item;
	}

}
