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

