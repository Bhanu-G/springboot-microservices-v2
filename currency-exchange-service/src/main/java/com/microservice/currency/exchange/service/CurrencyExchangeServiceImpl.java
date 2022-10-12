package com.microservice.currency.exchange.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.currency.exchange.model.CurrencyExchange;
import com.microservice.currency.exchange.repository.CurrencyExchangeRepository;

@Service
public class CurrencyExchangeServiceImpl implements CurrencyExchangeService {
	
	@Autowired
	private CurrencyExchangeRepository repository;

	@Override
	public CurrencyExchange getCurrencyExchangeRate(String from, String to) {
		return repository.findByFromAndTo(from, to);
	}

}
