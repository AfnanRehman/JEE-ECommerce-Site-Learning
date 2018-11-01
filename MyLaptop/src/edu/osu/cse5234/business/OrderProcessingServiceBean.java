package edu.osu.cse5234.business;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.xml.ws.WebServiceRef;

import com.chase.payment.*;

import edu.osu.cse5234.model.Order;
import edu.osu.cse5234.model.PaymentInfo;
import edu.osu.cse5234.util.ServiceLocator;

/**
 * Session Bean implementation class OrderProcessingServiceBean
 */
@Stateless
@LocalBean
public class OrderProcessingServiceBean {
	
	@WebServiceRef(wsdlLocation ="http://localhost:9080/ChaseBankApplication/PaymentProcessorService?wsdl")
	private PaymentProcessorService service;
	
	private int confirmationcode=0;
	
	@PersistenceContext
	EntityManager entityManager;

    /**
     * Default constructor. 
     */
    public OrderProcessingServiceBean() {
    }
    
    public String processOrder(Order order) {
    	CreditCardPayment ccPayment=new CreditCardPayment();
    	PaymentInfo pInfo=order.getPayment();
    	ccPayment.setCcNumber(pInfo.getCcNumber());
    	ccPayment.setCvvCode(pInfo.getCvvCode());
    	ccPayment.setExpDate(pInfo.getExpDate());
    	ccPayment.setHolderName(pInfo.getHolderName());
    	double value=0.0;
    	for(int i=0;i<order.getLineItems().size();i++) {
    		value+=order.getLineItems().get(i).getPrice()*order.getLineItems().get(i).getQuantity();
    	}
    	ccPayment.setPaymentAmount(value);
    	
    	String res=service.getPaymentProcessorPort().processPayment(ccPayment);
    	if(Integer.parseInt(res)<0) return "";
    	pInfo.setConfirmationNumber(res);
   
    	
    	
    	if(validateItemAvailability(order)){
    		confirmationcode++;
    		entityManager.persist(order);
    		entityManager.flush();
    		
    	}
    	
    	return confirmationcode+"";
    	
    }
    
    public boolean validateItemAvailability(Order order) {
    	return ServiceLocator.getInventoryService().validateQuantity(order.getItems());
    }
    

}
