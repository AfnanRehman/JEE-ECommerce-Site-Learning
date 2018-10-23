package edu.osu.cse5234.model;

import javax.persistence.*;


@Entity
@Table(name="PAYMENT_INFO")
public class PaymentInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	@Column(name="CARD_NUM")
	private String ccNumber;
	@Column(name="EXP_DATE")
	private String expDate;
	@Column(name="CVV")
	private String cvvCode;
	@Column(name="HOLDER_NAME")
	private String holderName;

	public PaymentInfo() { }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCcNumber() {
		return ccNumber;
	}

	public void setCcNumber(String ccNumber) {
		this.ccNumber = ccNumber;
	}

	public String getExpDate() {
		return expDate;
	}

	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}

	public String getCvvCode() {
		return cvvCode;
	}

	public void setCvvCode(String cvvCode) {
		this.cvvCode = cvvCode;
	}

	public String getHolderName() {
		return holderName;
	}

	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}
	
	
}
