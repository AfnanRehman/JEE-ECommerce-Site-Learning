package edu.osu.cse5234.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.osu.cse5234.model.*;

@Controller
@RequestMapping("/purchase")
public class Purchase {
	
	@RequestMapping(method = RequestMethod.GET)
	public String viewOrderEntryForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ArrayList<Item> itemList=new ArrayList<>();
		Order order=new Order();
		String name="item";
		String price="";
		String quantity="";

		
		for(int i=1;i<6;i++) {
			Item item=new Item();
			item.setName(name+i);
			item.setPrice(price+i);
			item.setQuantity(quantity+i);
			itemList.add(item);
		}
		order.setItemList(itemList);
		order.setOrderNumber(itemList.size()+"");
		request.setAttribute("order", order);
		
		return "ViewOrderEntryForm";
//		response.getWriter().println("Hello World Spring MVC!");
	}
	
	@RequestMapping(path = "/submitItems", method = RequestMethod.GET)
	public String printHelloNew() throws Exception {
		return "HelloJSP";
		
	}
}