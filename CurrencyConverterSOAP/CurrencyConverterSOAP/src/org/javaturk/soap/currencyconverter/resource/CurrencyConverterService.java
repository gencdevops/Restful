package org.javaturk.soap.currencyconverter.resource;

import java.util.List;

import org.javaturk.soap.currencyconverter.domain.Conversion;
import org.javaturk.soap.currencyconverter.domain.Conversions;
import org.javaturk.soap.currencyconverter.domain.Currency;

public interface CurrencyConverterService {

	Conversions getAllConversions();

	List<Currency> getAllCurrencies();

	Conversion convertByObject(Conversion conversionParameter);

	Conversion convertByParam(Currency sourceCurrency, Currency targetCurrency, double amount);

//	Conversion convertString(String sourceCurrencyString, String targetCurrencyString, double amount);
//
//	Conversion convertStringXML(String sourceCurrencyString, String targetCurrencyString, double amount);

}