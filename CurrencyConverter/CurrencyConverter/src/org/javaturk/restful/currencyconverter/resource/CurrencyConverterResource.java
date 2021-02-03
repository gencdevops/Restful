package org.javaturk.restful.currencyconverter.resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

import org.javaturk.restful.currencyconverter.converter.CurrencyConverter;
import org.javaturk.restful.currencyconverter.converter.CurrencyConverterEngine;
import org.javaturk.restful.currencyconverter.domain.Conversion;
import org.javaturk.restful.currencyconverter.domain.Conversions;
import org.javaturk.restful.currencyconverter.domain.Currency;
import org.javaturk.restful.currencyconverter.ex.InvalidCurrencyException;
import org.javaturk.restful.currencyconverter.validation.CurrencyValidator;

@Path("/conversions")
public class CurrencyConverterResource implements CurrencyConverterService{
	// Just to see how many instances are created.
//	private static int counter;
//	private int objectCounter;
	private static Conversions conversions = new Conversions();
	private CurrencyConverter converter = new CurrencyConverterEngine();
	private CurrencyValidator currencyValidator = new CurrencyValidator();
	
	public CurrencyConverterResource() {
		// Just to see how many instances are created.
//		counter++;
//		objectCounter = counter;
//		System.out.println("Object count: " + objectCounter);
	}
	
	@Override
	@GET
	@Produces("application/json")
	public Conversions getAllConversions() {
		Conversions conversions = new Conversions();
		conversions.setConversions(CurrencyConverterResource.conversions.getConversions());
		return conversions;
	}
	
	@Override
	@Path("/currencies")
	@GET
	@Produces("application/json")
	public List<Currency> getAllCurrencies() {
		return Currency.getCurrencyList();
	}
	
	@Override
	@POST
	@Produces("application/json")
	public Conversion convert(Conversion conversionParameter) {
		Conversion conversion = converter.convert(conversionParameter);
		conversions.addConversion(conversion);
		return conversion;
	}
	
	@Override
	@POST
	@Path("{from}/{to}/{amount}")
	@Produces("application/json")
	public Conversion convert(@PathParam("from") Currency sourceCurrency, @PathParam("to") Currency targetCurrency, @PathParam("amount") double amount) {
		Conversion conversion = null;
		double targetAmount = converter.convert(sourceCurrency, targetCurrency, amount);
		conversion = new Conversion(sourceCurrency, targetCurrency, amount, targetAmount);
		conversions.addConversion(conversion);
		return conversion;
	}
	
	@Override
	@POST
	@Path("string/{from}/{to}/{amount}")
	@Produces("application/json")
	public Conversion convertString(@PathParam("from") String sourceCurrencyString, @PathParam("to") String targetCurrencyString, @PathParam("amount") double amount) {
		if(!currencyValidator.validate(sourceCurrencyString)) {
			System.out.println("Bad Request: " + InvalidCurrencyException.INVALID_SOURCE_CURRENCY_MESSAGE);
			throw new InvalidCurrencyException(InvalidCurrencyException.INVALID_SOURCE_CURRENCY_MESSAGE, Response.Status.BAD_REQUEST);
		}
		if(!currencyValidator.validate(targetCurrencyString)) {
			System.out.println("Bad Request: " + InvalidCurrencyException.INVALID_TARGET_CURRENCY_MESSAGE);
			throw new InvalidCurrencyException(InvalidCurrencyException.INVALID_TARGET_CURRENCY_MESSAGE, Response.Status.BAD_REQUEST);
		}
		
		Currency sourceCurrency = Currency.switchToCurrency(sourceCurrencyString);
		Currency targetCurrency = Currency.switchToCurrency(targetCurrencyString);
		Conversion conversion = null;
		double targetAmount = converter.convert(sourceCurrency, targetCurrency, amount);
		conversion = new Conversion(sourceCurrency, targetCurrency, amount, targetAmount);
		conversions.addConversion(conversion);
		return conversion;
	}
	
	@Override
	@POST
	@Path("string/xml/{from}/{to}/{amount}")
	@Produces("application/xml")
	public Conversion convertStringXML(@PathParam("from") String sourceCurrencyString, @PathParam("to") String targetCurrencyString, @PathParam("amount") double amount) {
		if(!currencyValidator.validate(sourceCurrencyString)) {
			System.out.println("Bad Request: " + InvalidCurrencyException.INVALID_SOURCE_CURRENCY_MESSAGE);
			throw new InvalidCurrencyException(InvalidCurrencyException.INVALID_SOURCE_CURRENCY_MESSAGE, Response.Status.BAD_REQUEST);
		}
		if(!currencyValidator.validate(targetCurrencyString)) {
			System.out.println("Bad Request: " + InvalidCurrencyException.INVALID_TARGET_CURRENCY_MESSAGE);
			throw new InvalidCurrencyException(InvalidCurrencyException.INVALID_TARGET_CURRENCY_MESSAGE, Response.Status.BAD_REQUEST);
		}
		
		Currency sourceCurrency = Currency.switchToCurrency(sourceCurrencyString);
		Currency targetCurrency = Currency.switchToCurrency(targetCurrencyString);
		Conversion conversion = null;
		double targetAmount = converter.convert(sourceCurrency, targetCurrency, amount);
		conversion = new Conversion(sourceCurrency, targetCurrency, amount, targetAmount);
		conversions.addConversion(conversion);
		return conversion;
	}
}
