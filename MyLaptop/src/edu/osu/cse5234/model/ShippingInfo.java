package edu.osu.cse5234.model;

import javax.persistence.*;

@Entity
@Table(name="SHIPPING_INFO")
public class ShippingInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	@Transient
	private String name;
	@Transient
	private String addLine1;
	@Transient
	private String addLine2;
	@Transient
	private String city;
	@Transient
	private String state;
	@Transient
	private String zip;

	public ShippingInfo() { }
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;		
	}
	
	public String getAddLine1() {
		return addLine1;
	}
	
	public String getAddLine2() {
		return addLine2;
	}
	
	public String getCity() {
		return city;
	}
	public String getState() {
		return state;
	}
	
	public String getZip() {
		return zip;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setAddLine1(String addLine1) {
		this.addLine1 = addLine1;
	}
	public void setAddLine2(String addLine2) {
		this.addLine2 = addLine2;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setState(String state) {
		this.state = state;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}

}
