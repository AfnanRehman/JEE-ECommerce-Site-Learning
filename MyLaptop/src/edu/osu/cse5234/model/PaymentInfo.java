package edu.osu.cse5234.model;

import javax.persistence.*;


@Entity
@Table(name="PAYMENT_INFO")
public class PaymentInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	@Transient
	private String ccNumber;
	@Transient
	private String expDate;
	@Transient
	private String cvvCode;
	@Transient
	private String holderName;

	public PaymentInfo() { }
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getHolderName() {
		return holderName;		
	}
	
	public String getccNumber() {
		return ccNumber;
	}
	
	public String getexpDate() {
		return expDate;
	}
	
	public String getcvvCode() {
		return cvvCode;
	}
	
	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}
	public void setccNumber(String ccNumber) {
		this.ccNumber = ccNumber;
	}
	public void setexpDate(String expDate) {
		this.expDate = expDate;
	}
	public void setcvvCode(String cvvCode) {
		this.cvvCode = cvvCode;
	}
}

