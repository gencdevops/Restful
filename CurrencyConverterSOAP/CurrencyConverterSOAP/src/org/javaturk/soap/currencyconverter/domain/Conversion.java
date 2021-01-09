package org.javaturk.soap.currencyconverter.domain;

import java.time.Instant;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Conversion {
	private static int count;
	private int id;

	{
		id = ++count;
	}

	@XmlElement(name="Source-Currency")
	private Currency sourceCurrency;
	
	@XmlElement(name="Target-Currency")
	private Currency targetCurrency;

	@XmlElement(name="Source-Amount")
	private double sourceAmount;
	
	@XmlElement(name="Target-Amount")
	private double targetAmount;

	@XmlElement(name="Conversion-Date")
	private Date date;

	public Conversion() {
		date = new Date();
	}

	public Conversion(Currency sourceCurrency, Currency targetCurrency, double sourceAmount) {
		this.sourceCurrency = sourceCurrency;
		this.targetCurrency = targetCurrency;
		this.sourceAmount = sourceAmount;
		date = new Date();
	}

	public Conversion(Currency sourceCurrency, Currency targetCurrency, double sourceAmount, double targetAmount) {
		this.sourceCurrency = sourceCurrency;
		this.targetCurrency = targetCurrency;
		this.sourceAmount = sourceAmount;
		this.targetAmount = targetAmount;
		date = new Date();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Currency getSourceCurrency() {
		return sourceCurrency;
	}

	public void setSourceCurrency(Currency sourceCurrency) {
		this.sourceCurrency = sourceCurrency;
	}

	public Currency getTargetCurrency() {
		return targetCurrency;
	}

	public void setTargetCurrency(Currency targetCurrency) {
		this.targetCurrency = targetCurrency;
	}

	public double getSourceAmount() {
		return sourceAmount;
	}

	public void setSourceAmount(double sourceAmount) {
		this.sourceAmount = sourceAmount;
	}

	public double getTargetAmount() {
		return targetAmount;
	}

	public void setTargetAmount(double targetAmount) {
		this.targetAmount = targetAmount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Conversion [Source currency=" + sourceCurrency + ", Target currency=" + targetCurrency + ", sourceAmount="
				+ sourceAmount + ", Target amount=" + targetAmount + ", Date=" + date + "]";
	}
}
