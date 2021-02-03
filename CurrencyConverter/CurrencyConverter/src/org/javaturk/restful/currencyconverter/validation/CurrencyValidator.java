package org.javaturk.restful.currencyconverter.validation;

import org.javaturk.restful.currencyconverter.domain.Currency;

public class CurrencyValidator {
	
	public boolean validate(String currency) {
		boolean validated = false;
		if(currency.equals(Currency.TRY.name()) | currency.equals(Currency.USD.name()) | currency.equals(Currency.EUR.name()))
				validated = true;
			return validated;
	}
}
