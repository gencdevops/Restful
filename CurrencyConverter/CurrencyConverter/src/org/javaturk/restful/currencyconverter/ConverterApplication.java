package org.javaturk.restful.currencyconverter;

import java.util.*;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.javaturk.restful.currencyconverter.resource.CurrencyConverterResource;

@ApplicationPath("/resources")
public class ConverterApplication extends Application{
	Set<Object> singletons = new HashSet<>();
	
	/**
	 * To make service object a singleton.
	 */
	public Set<Object> getSingletons(){
//		System.out.println("In getSingletons()");
		singletons.add(new CurrencyConverterResource());
		return singletons;
	}
}
