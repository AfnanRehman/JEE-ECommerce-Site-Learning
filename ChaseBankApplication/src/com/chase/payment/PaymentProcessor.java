package com.chase.payment;

public class PaymentProcessor {
	public String ping(){
		return "ping";
	}
	
	public String processPayment(CreditCardPayment creditCardPayment) {
		return "1";
	}
}
