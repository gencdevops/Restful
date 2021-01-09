package org.javaturk.soap.currencyconverter.converter;

import static org.javaturk.soap.currencyconverter.domain.Currency.*;
import org.javaturk.soap.currencyconverter.domain.Conversion;
import org.javaturk.soap.currencyconverter.domain.Currency;

public class CurrencyConverterEngine implements CurrencyConverter {

	public Conversion convert(Conversion conversion) {
		double targetAmount = convert(conversion.getSourceCurrency(), conversion.getTargetCurrency(),
				conversion.getSourceAmount());
		conversion.setTargetAmount(targetAmount);
		return conversion;
	}

	public double convert(Currency sourceCurrency, Currency targetCurrency, double sourceAmount) {
		double targetAmount = 0;
		// First check if source and target currencies are the same.
		if(sourceCurrency.equals(targetCurrency))
			return sourceAmount;
		if (sourceCurrency.equals(TRY)) {
			switch (targetCurrency) {
			case USD:
				targetAmount = sourceAmount / 5;
				break;
			case EUR:
				targetAmount = sourceAmount / 6;
				break;
			}
		} else if (sourceCurrency.equals(USD)) {
			switch (targetCurrency) {
			case TRY:
				targetAmount = sourceAmount * 5;
				break;
			case EUR:
				targetAmount = sourceAmount / 1.2;
				break;
			}
		} else if (sourceCurrency.equals(EUR)) {
			switch (targetCurrency) {
			case TRY:
				targetAmount = sourceAmount * 6;
				break;
			case USD:
				targetAmount = sourceAmount * 1.2;
				break;
			}
		}
		return targetAmount;
	}
}
