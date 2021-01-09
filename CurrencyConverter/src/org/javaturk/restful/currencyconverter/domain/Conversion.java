package org.javaturk.restful.currencyconverter.domain;

import java.time.Instant;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Conversion {
	private static int count;
	private int id;

	{
		id = ++count;
	}

	private Currency sourceCurrency;
	private Currency targetCurrency;

	private double sourceAmount;
	private double targetAmount;

	private Instant date;

	public Conversion() {

	}

	public Conversion(Currency sourceCurrency, Currency targetCurrency, double sourceAmount) {
		this.sourceCurrency = sourceCurrency;
		this.targetCurrency = targetCurrency;
		this.sourceAmount = sourceAmount;
		date = Instant.now();
	}

	public Conversion(Currency sourceCurrency, Currency targetCurrency, double sourceAmount, double targetAmount) {
		this.sourceCurrency = sourceCurrency;
		this.targetCurrency = targetCurrency;
		this.sourceAmount = sourceAmount;
		this.targetAmount = targetAmount;
		date = Instant.now();
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

	public Instant getDate() {
		return date;
	}

	public void setDate(Instant date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Conversion [Source currency=" + sourceCurrency + ", Target currency=" + targetCurrency + ", sourceAmount="
				+ sourceAmount + ", Target amount=" + targetAmount + ", Date=" + date + "]";
	}
}
