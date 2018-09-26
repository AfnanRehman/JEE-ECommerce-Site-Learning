package edu.osu.cse5234.model;

public class Order {
	private String MacBook = null;
	private String Dell = null;
	private String Hp = null;
	
	public Order() { }
	
	public String getMacBook() {
		return MacBook;		
	}
	
	public String getDell() {
		return Dell;
	}
	
	public String getHp() {
		return Hp;
	}
	
	public void setMacBook(String MacBook) {
		this.MacBook = MacBook;
	}
	public void setDell(String Dell) {
		this.Dell = Dell;
	}
	public void setHp(String Hp) {
		this.Hp = Hp;
	}
}
