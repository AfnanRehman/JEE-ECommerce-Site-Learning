package edu.osu.cse5234.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


@Entity
@Table(name="CUSTOMER_ORDER")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;


	@Column(name="CUSTOMER_NAME")
	private String customerName;
	@Column(name="CUSTOMER_EMAIL")
	private String emailAddress;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="CUSTOMER_ORDER_ID_FK")
	private List<LineItem> lineItems;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="PAYMENT_INFO_ID_FK")
	private PaymentInfo payment;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="SHIPPING_INFO_ID_FK")
	private ShippingInfo shipping;



	public Order() { }

	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getCustomerName() {
		return customerName;
	}


	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	public String getEmailAddress() {
		return emailAddress;
	}


	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}


	public List<LineItem> getLineItems() {
		return lineItems;
	}


	public void setLineItems(List<LineItem> lineItems) {
		this.lineItems = lineItems;
	}
	
	
	public List<Item> getItems(){
		List<Item> res=new ArrayList<>();
		for(LineItem lItem:this.lineItems) {
			if(lItem.getQuantity()>0) res.add(lItem.getItem());
		}
		return res;	
	}

	
	public PaymentInfo getPayment() {
		return payment;
	}


	public void setPayment(PaymentInfo payment) {
		this.payment = payment;
	}


	public ShippingInfo getShipping() {
		return shipping;
	}


	public void setShipping(ShippingInfo shipping) {
		this.shipping = shipping;
	}

	
}
