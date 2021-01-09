package org.javaturk.restful.currencyconverter.ex;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

public class InvalidCurrencyException extends WebApplicationException{
	public static final String INVALID_SOURCE_CURRENCY_MESSAGE = "Source currency is not supported!";
	public static final String INVALID_TARGET_CURRENCY_MESSAGE = "Target currency is not supported!";
	
	public InvalidCurrencyException(String message, Response.Status status) {
		super(message, status);
	}
}
