package org.javaturk.soap.currencyconverter.converter;

import org.javaturk.soap.currencyconverter.domain.Conversion;
import org.javaturk.soap.currencyconverter.domain.Currency;

public interface CurrencyConverter {

	public double convert(Currency sourceCurrency, Currency targetCurrency, double sourceAmount);

	public Conversion convert(Conversion conversion);
}
