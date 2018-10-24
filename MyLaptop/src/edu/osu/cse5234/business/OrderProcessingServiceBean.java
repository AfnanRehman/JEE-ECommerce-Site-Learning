package edu.osu.cse5234.business;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import edu.osu.cse5234.model.Order;
import edu.osu.cse5234.util.ServiceLocator;

/**
 * Session Bean implementation class OrderProcessingServiceBean
 */
@Stateless
@LocalBean
public class OrderProcessingServiceBean {
	private int confirmationcode=0;
	
	@PersistenceContext
	EntityManager entityManager;

    /**
     * Default constructor. 
     */
    public OrderProcessingServiceBean() {
        // TODO Auto-generated constructor stub
    }
    
    public String processOrder(Order order) {
    	// TODO
    	
    	if(validateItemAvailability(order)){
    		confirmationcode++;
    		entityManager.persist(order);
    		entityManager.flush();
//    		is.updateInventory(order.getItems());
    		
    	}
    	
    	return confirmationcode+"";
    	
    }
    
    public boolean validateItemAvailability(Order order) {
    	return ServiceLocator.getInventoryService().validateQuantity(order.getItems());
    }
    

}
