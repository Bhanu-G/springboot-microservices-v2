package com.microservice.currency.exchange.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
public class CircuitBreakerController {
	
	private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);
	
	@GetMapping("/sample-api")
//	@Retry(name = "sample-api", fallbackMethod = "fallbackResponse")
//	@CircuitBreaker(name = "default", fallbackMethod = "fallbackResponse")
//	@RateLimiter(name = "default")
	@Bulkhead(name="sample-api")
	public String sampleAPI() {
		logger.info("Sample API retries");
		ResponseEntity<String> forEntity = new RestTemplate().getForEntity("http://localhost:1111", String.class);
		return forEntity.getBody();
	}
	
	public String fallbackResponse(Exception e) {
		return "Something went wrong!";
	}

}
