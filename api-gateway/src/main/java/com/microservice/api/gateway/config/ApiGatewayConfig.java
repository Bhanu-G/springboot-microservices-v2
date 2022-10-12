package com.microservice.api.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfig {
	
	@Bean
	public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
		return builder.routes().route(r -> r.path("/api/currency-exchange/**").uri("lb://currency-exchange-service"))
					  .route( r -> r.path("/api/currency-conversion/**").uri("lb://currency-conversion-service"))
					  .route(r -> r.path("/api/currency-conversion-feign/**").uri("lb://currency-conversion-service"))
					  .route( r -> r.path("/api/currency-conversion-new/**")
							  .filters( f -> f.rewritePath("/api/currency-conversion-new/(?<segment>.*)", "/api/currency-conversion-feign/${segment}"))
							  .uri("lb://currency-conversion-service"))
					.build();
		
	}

}
