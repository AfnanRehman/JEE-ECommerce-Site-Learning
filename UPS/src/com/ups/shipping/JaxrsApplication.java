package com.ups.shipping;

import java.util.HashSet;
import java.util.Set;


import javax.ws.rs.core.Application;

public class JaxrsApplication extends Application {

	public JaxrsApplication() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> classes = new HashSet<Class<?>>();
		classes.add(ShippingInitiation.class);
		return classes;
	}

}
