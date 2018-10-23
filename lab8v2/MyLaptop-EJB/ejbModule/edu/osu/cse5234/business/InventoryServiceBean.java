package edu.osu.cse5234.business;

import edu.osu.cse5234.business.view.Inventory;
import edu.osu.cse5234.business.view.InventoryService;
import edu.osu.cse5234.model.Item;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.*;

/**
 * Session Bean implementation class InventoryServiceBean
 */
@Stateless
@Remote(InventoryService.class)
 
public class InventoryServiceBean implements InventoryService {
	private List<Item> itemList;
	static String MY_QUERY = "Select i from Item i";

	@PersistenceContext
	EntityManager entityManager;
	
	/**
	 * Default constructor.
	 */
	public InventoryServiceBean() {
		
	}

	@Override
	public Inventory getAvailableInventory() {
		// TODO Auto-generated method stub
		Inventory res = new Inventory();
		itemList=entityManager.createQuery(MY_QUERY, Item.class).getResultList();
		res.setList(itemList);
		return res;
	}

	@Override
	public boolean validateQuantity(List<Item> items) {
		// TODO Auto-generated method stub
		for(Item item:items) {
			Item invenItem=entityManager.createQuery("select i from Item i where i.itemNo="+item.getItemNo(),Item.class).getSingleResult();
			if(item.getQuantity()<=0 || item.getQuantity()>invenItem.getQuantity()) return false;
		}
//		for (int i = 0; i < items.size(); i++) {
//			int inv_count = itemList.get(i).getQuantity();
//			int ord_count = items.get(i).getQuantity();
//			if (inv_count < ord_count || ord_count < 0) {
//				return false;
//			}
//		}
		return true;
	}

	@Override
	public boolean updateInventory(List<Item> items) {
		// TODO Auto-generated method stub
		for (int i = 0; i < items.size(); i++) {
			int inv_count = itemList.get(i).getQuantity();
			int ord_count = items.get(i).getQuantity();
			itemList.get(i).setQuantity(inv_count-ord_count);
		}
		return true;
	}

}
