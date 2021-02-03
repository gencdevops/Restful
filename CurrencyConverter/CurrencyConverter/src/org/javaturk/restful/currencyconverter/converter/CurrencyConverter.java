package org.javaturk.restful.currencyconverter.converter;

import org.javaturk.restful.currencyconverter.domain.Conversion;
import org.javaturk.restful.currencyconverter.domain.Currency;

public interface CurrencyConverter {
	
	public double convert(Currency sourceCurrency, Currency targetCurrency, double sourceAmount);
	
	public Conversion convert(Conversion conversion);
	
}
