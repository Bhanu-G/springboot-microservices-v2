package com.microservice.currency.conversion.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.microservice.currency.conversion.model.CurrencyConversion;

@FeignClient(name = "currency-exchange-service"	)	 // not required when we loadbalancing url = "localhost:8001/api")
public interface CurrencyExchangeServiceProxy {
	
	@GetMapping("/api/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversion getCurrencyExchangeRate(@PathVariable("from") String from, @PathVariable("to") String to);

}
