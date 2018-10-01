package edu.osu.cse5234.model;

public class ShippingInfo {
//comment
	private String name = null;
	private String addLine1 = null;
	private String addLine2 = null;
	private String city = null;
	private String state = null;
	private String zip = null;

	public ShippingInfo() { }
	
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
