package com.microservice.currency.exchange.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.currency.exchange.model.CurrencyExchange;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long> {
	
	CurrencyExchange findByFromAndTo(String from, String to);
}
