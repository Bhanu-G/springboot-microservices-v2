package com.microservice.currency.conversion.service;

import java.math.BigDecimal;

import com.microservice.currency.conversion.model.CurrencyConversion;

public interface CurrencyConversionService {
	
	CurrencyConversion calculateCurrencyConversion(String from, String to, BigDecimal quantity);

	CurrencyConversion calculateCurrencyConversionWithFeign(String from, String to, BigDecimal quantity);

}
