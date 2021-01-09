package org.javaturk.soap.currencyconverter.resource;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import org.javaturk.soap.currencyconverter.domain.Conversions;
import org.javaturk.soap.currencyconverter.converter.CurrencyConverter;
import org.javaturk.soap.currencyconverter.converter.CurrencyConverterEngine;
import org.javaturk.soap.currencyconverter.domain.Conversion;
import org.javaturk.soap.currencyconverter.domain.Currency;

//@WebService(targetNamespace="http://www.javaturk.org", portName="CurrencyConverterPort")
//@WebService(endpointInterface="CurrencyConverterService")
@WebService(targetNamespace="http://www.javaturk.org")
public class CurrencyConverterResource implements CurrencyConverterService{
	private CurrencyConverter converter = new CurrencyConverterEngine();
	private static Conversions conversions = new Conversions();

	@Override
	@WebMethod(action="convert-currency", operationName="currency-converter")
	public Conversion convertByParam(@WebParam(name="Source-Currency") Currency sourceCurrency, @WebParam(name="Target-Currency")Currency targetCurrency, @WebParam(name="Amount")double amount) {
		Conversion conversion = null;
		double targetAmount = converter.convert(sourceCurrency, targetCurrency, amount);
		conversion = new Conversion(sourceCurrency, targetCurrency, amount, targetAmount);
		conversions.addConversion(conversion);
		return conversion;
	}
	@Override
	@WebMethod(action="convert-currency-by-parameter", operationName="currency-converter-by-parameter")
	public Conversion convertByObject(Conversion conversionParameter) {
		Conversion conversion = converter.convert(conversionParameter);
		conversions.addConversion(conversion);
		return conversion;
	}

	@Override
	@WebMethod(action="get-all-conversions", operationName="all-conversions")
	public @WebResult(name="All-Conversions") Conversions getAllConversions() {
		Conversions conversions = new Conversions();
		conversions.setConversions(CurrencyConverterResource.conversions.getConversions());
		return conversions;
	}

	@Override
	@WebMethod(action="get-all-currencies", operationName="all-currencies")
	public @WebResult(name="Currency-List") List<Currency> getAllCurrencies() {
		return Currency.getCurrencyList();
	}
}

