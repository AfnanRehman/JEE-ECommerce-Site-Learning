package edu.osu.cse5234.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="ITEM")
public class Item implements Serializable{
	/**
	 * 
	 */
	@Transient
	private static final long serialVersionUID = 9114872907196583964L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	@Column(name="NAME")
	private String name;
	@Column(name="DESCRIPTION")
	private String description;
	@Column(name="UNIT_PRICE")
	private double price;
	@Column(name="ITEM_NUMBER")
	private int itemNo;
	@Column(name="AVAILABLE_QUANTITY")
	private int quantity; 

	
	public Item() { }
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public int getItemNo() {
		return itemNo;
	}

	public void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}

	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
