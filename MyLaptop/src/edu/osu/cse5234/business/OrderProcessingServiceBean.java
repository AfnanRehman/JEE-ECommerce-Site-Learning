package edu.osu.cse5234.business;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import edu.osu.cse5234.business.view.InventoryService;
import edu.osu.cse5234.model.Order;
import edu.osu.cse5234.util.ServiceLocator;

/**
 * Session Bean implementation class OrderProcessingServiceBean
 */
@Stateless
@LocalBean
public class OrderProcessingServiceBean {
	private int confirmationcode=0;

    /**
     * Default constructor. 
     */
    public OrderProcessingServiceBean() {
        // TODO Auto-generated constructor stub
    }
    
    public String processOrder(Order order) {
    	// TODO
    	InventoryService is=ServiceLocator.getInventoryService();
    	if(is.validateQuantity(order.getItems())){
    		confirmationcode++;
    		is.updateInventory(order.getItems());
    		
    	}
    	
    	return confirmationcode+"";
    	
    }
    
    public boolean validateItemAvailability(Order order) {
    	
    	return ServiceLocator.getInventoryService().validateQuantity(order.getItems());
    }
    

}
