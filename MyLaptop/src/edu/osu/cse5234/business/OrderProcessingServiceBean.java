package edu.osu.cse5234.business;

import edu.osu.cse5234.business.view.Inventory;
import edu.osu.cse5234.business.view.InventoryService;
import edu.osu.cse5234.model.Item;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class InventoryServiceBean
 */
@Stateless
@Remote(InventoryService.class)
public class InventoryServiceBean implements InventoryService {
	private List<Item> itemList;

	/**
	 * Default constructor.
	 */
	public InventoryServiceBean() {
		// TODO Auto-generated constructor stub
		itemList = new ArrayList<>();
		String name = "";
		String price = "10";
		String[] laptops = { "", "MacBook", "Lenovo", "HP", "Dell", "Thinkpad" };

		for (int i = 1; i < 6; i++) {
			Item item = new Item();
			item.setName(name + laptops[i]);
			item.setPrice(price + (i * 4));
			item.setQuantity("2");
			itemList.add(item);
		}
	}

	@Override
	public Inventory getAvailableInventory() {
		// TODO Auto-generated method stub
		Inventory res = new Inventory();
		res.setList(itemList);
		return res;
	}

	@Override
	public boolean validateQuantity(List<Item> items) {
		// TODO Auto-generated method stub
		for (int i = 0; i < items.size(); i++) {
			int inv_count = Integer.parseInt(itemList.get(i).getQuantity());
			int ord_count = Integer.parseInt(items.get(i).getQuantity());
			if (inv_count < ord_count || ord_count < 0) {
				
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean updateInventory(List<Item> items) {
		// TODO Auto-generated method stub
		for (int i = 0; i < items.size(); i++) {
			int inv_count = Integer.parseInt(itemList.get(i).getQuantity());
			int ord_count = Integer.parseInt(items.get(i).getQuantity());
			itemList.get(i).setQuantity(String.valueOf(inv_count-ord_count));
		}
		return true;
	}

}
