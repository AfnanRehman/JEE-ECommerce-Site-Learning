package edu.osu.cse5234.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.osu.cse5234.model.ShippingInfo;


@Controller
@RequestMapping("/")
public class Homepage {
	@RequestMapping(method = RequestMethod.POST)
	public String returnHome(@ModelAttribute("shipping") ShippingInfo shippingInfo,
			HttpServletRequest request) {
			return "redirect:/";
	}
	@RequestMapping(method = RequestMethod.GET)
 	public String viewHome(HttpServletRequest request, HttpServletResponse respons) {
 		return "home";
 	}
	
	
	@RequestMapping(path="about", method = RequestMethod.GET)
 	public String viewAboutUs(HttpServletRequest request, HttpServletResponse respons) {
 		return "AboutUs";
 	}
	
	@RequestMapping(path="contact", method = RequestMethod.GET)
 	public String viewContactUs(HttpServletRequest request, HttpServletResponse respons) {
 		return "ContactUs";
 	}

}
