package edu.osu.cse5234.business.view;

import java.io.Serializable;
import java.util.List;

import edu.osu.cse5234.model.Item;

public class Inventory implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -872344271112964171L;
	private List<Item> list;
	
	

	public Inventory() {

	}

	public List<Item> getList() {
		return list;
	}

	public void setList(List<Item> list) {
		this.list = list;
	}
	
	
	

}
