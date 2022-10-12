package com.microservice.currency.conversion.service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microservice.currency.conversion.model.CurrencyConversion;

@Service
public class CurrencyConversionServiceImpl implements CurrencyConversionService {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private CurrencyExchangeServiceProxy serviceProxy;

	@Override
	public CurrencyConversion calculateCurrencyConversion(String from, String to, BigDecimal quantity) {
		Map<String, String> uriVariables = new HashMap<String, String>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);
		ResponseEntity<CurrencyConversion> responseEntity = restTemplate.getForEntity(
				"http://localhost:8001/api/currency-exchange/from/{from}/to/{to}", CurrencyConversion.class, uriVariables);
		CurrencyConversion currencyConversion = responseEntity.getBody();
		return new CurrencyConversion(currencyConversion.getId(), from, to, currencyConversion.getConversionMultiple(),
				quantity, quantity.multiply(currencyConversion.getConversionMultiple()), currencyConversion.getEnvironment() + " Rest Template");
	}
	
	@Override
	public CurrencyConversion calculateCurrencyConversionWithFeign(String from, String to, BigDecimal quantity) {
		CurrencyConversion currencyConversion = serviceProxy.getCurrencyExchangeRate(from, to);
		return new CurrencyConversion(currencyConversion.getId(), from, to, currencyConversion.getConversionMultiple(),
				quantity, quantity.multiply(currencyConversion.getConversionMultiple()), currencyConversion.getEnvironment() + " Feign Client");
	}
}
