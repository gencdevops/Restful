package org.javaturk.restful.currencyconverter.resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.javaturk.restful.currencyconverter.domain.Conversion;
import org.javaturk.restful.currencyconverter.domain.Conversions;
import org.javaturk.restful.currencyconverter.domain.Currency;

public interface CurrencyConverterService {

	Conversions getAllConversions();

	List<Currency> getAllCurrencies();

	Conversion convert(Conversion conversionParameter);

	Conversion convert(Currency sourceCurrency, Currency targetCurrency, double amount);

	Conversion convertString(String sourceCurrencyString, String targetCurrencyString, double amount);

	Conversion convertStringXML(String sourceCurrencyString, String targetCurrencyString, double amount);

}