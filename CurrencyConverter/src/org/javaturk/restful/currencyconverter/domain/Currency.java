package org.javaturk.restful.currencyconverter.domain;

import java.util.Arrays;
import java.util.List;

public enum Currency {
	TRY("Turkish Lira"), USD("US Dollar"), EUR("EURO");
	
	private String description;
	
	private Currency(String description) {
		this.description = description;
	}
	
	public static List<Currency> getCurrencyList(){
		List<Currency> list =Arrays.asList(Currency.values());
		return list;
	}
	
	public static Currency switchToCurrency(String currencyString) {
		Currency currency = null;
		switch (currencyString) {
		case "TRY":
			currency = Currency.TRY;
			break;
			
		case "USD":
			currency = Currency.USD;
			break;
			
		case "EUR":
			currency = Currency.EUR;
			break;
		}	
		
		return currency;
	}
}
