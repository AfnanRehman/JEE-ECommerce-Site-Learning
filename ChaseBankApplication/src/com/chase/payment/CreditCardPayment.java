package com.chase.payment;

import java.io.Serializable;



public class CreditCardPayment implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1564356467075159559L;

	private int id;

	private String ccNumber;

	private String expDate;

	private String cvvCode;

	private String holderName;
	
	private double paymentAmount;
	
	

	public CreditCardPayment() {
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

	public double getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}
	

	
}
