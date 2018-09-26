package edu.osu.cse5234.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import edu.osu.cse5234.model.*;
//import edu.osu.cse5234.model.*;

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
	@RequestMapping(method = RequestMethod.GET)
	public String viewOrderEntryPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		Order order = request.getAttribute("order");
//		response.getWriter().println("order's name:" + order.)
		return "OrderEntryForm";
	}

	

	@RequestMapping(path = "/submitItems", method = RequestMethod.POST)
	public String submitItems(@ModelAttribute("order") Order order, HttpServletRequest request) {
		request.getSession().setAttribute("order", order);
		return "redirect:/purchase/paymentEntry";
	}
	
	@RequestMapping(path = "/paymentEntry", method = RequestMethod.GET)
	public String viewPaymentEntryPage(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("payment", new PaymentInfo());	
		return "PaymentEntryForm";
	}
	
	@RequestMapping(path = "/submitPayment", method = RequestMethod.POST)
	public String  	submitPayment(@ModelAttribute("paymentInfo") PaymentInfo paymentInfo, HttpServletRequest request) {
		request.getSession().setAttribute("paymentInfo", paymentInfo);
		return "redirect:/purchase/shippingEntry";
	}	
	
	@RequestMapping(path = "/shippingEntry", method = RequestMethod.GET)
	public String viewShippingEntryPage(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("payment", new ShippingInfo());	
		return "ShippingEntryForm";
	}
	
	@RequestMapping(path = "/submitShipping", method = RequestMethod.POST)
	public String  	submitShipping(@ModelAttribute("shippingInfo") ShippingInfo shippingInfo, HttpServletRequest request) {
		request.getSession().setAttribute("paymentInfo", shippingInfo);
		return "redirect:/purchase/viewOrder";
	}	
	

	@RequestMapping(path = "/viewOrder", method = RequestMethod.GET)
	public String viewOrder(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("payment", new Order());	
		return "viewOrderEntry";
	}
	
	@RequestMapping(path = "/confirmOrder", method = RequestMethod.POST)
	public String  	confirmOrder(@ModelAttribute("order") Order order, HttpServletRequest request) {
		request.getSession().setAttribute("order", order);
		return "redirect:/purchase/viewConfirmation";
	}
	
	@RequestMapping(path = "/viewConfirmation", method = RequestMethod.GET)
	public String  viewConfirmation(HttpServletRequest request, HttpServletResponse response) {
//		display order detail.
		return "redirect:/purchase";
	}
	
}