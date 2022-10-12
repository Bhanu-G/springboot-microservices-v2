	package com.microservice.currency.conversion.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.currency.conversion.model.CurrencyConversion;
import com.microservice.currency.conversion.service.CurrencyConversionService;

@RestController
@RequestMapping("/api")
public class CurrencyConversionController {
	
	@Autowired
	private CurrencyConversionService conversionService;

	@GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion calculateCurrencyConversion(@PathVariable("from") String from,
			@PathVariable("to") String to, @PathVariable("quantity") BigDecimal quantity) {
		return conversionService.calculateCurrencyConversion(from, to, quantity);

	}
	
	@GetMapping("/currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion calculateCurrencyConversionWithFeign(@PathVariable("from") String from,
			@PathVariable("to") String to, @PathVariable("quantity") BigDecimal quantity) {
		return conversionService.calculateCurrencyConversionWithFeign(from, to, quantity);

	}
}
