package com.microservice.currency.exchange.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.currency.exchange.model.CurrencyExchange;
import com.microservice.currency.exchange.service.CurrencyExchangeService;

@RestController
@RequestMapping("/api")
public class CurrencyExchangeController {
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private CurrencyExchangeService exchangeService;
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange getCurrencyExchangeRate(@PathVariable("from") String from, @PathVariable("to") String to) {
		CurrencyExchange currencyExchange = exchangeService.getCurrencyExchangeRate(from, to);
		if (currencyExchange == null) {
			throw new RuntimeException("Unable to get currency exchange from " + from + " to " + to);
		}
		currencyExchange.setEnvironment(environment.getProperty("local.server.port"));
		return currencyExchange;
	}

}
