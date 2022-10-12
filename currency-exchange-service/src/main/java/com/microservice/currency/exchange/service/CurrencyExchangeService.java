package com.microservice.currency.exchange.service;

import org.springframework.stereotype.Repository;

import com.microservice.currency.exchange.model.CurrencyExchange;

@Repository
public interface CurrencyExchangeService {
	
	CurrencyExchange getCurrencyExchangeRate(String from, String to);
}
