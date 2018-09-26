package edu.osu.cse5234.model;

public class PaymentInfo {

	private String ccNumber = null;
	private String expDate = null;
	private String cvvCode = null;
	private String holderName = null;

	public PaymentInfo() { }
	
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
