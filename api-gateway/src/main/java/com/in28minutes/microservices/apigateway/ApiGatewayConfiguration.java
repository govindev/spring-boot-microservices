package com.in28minutes.microservices.apigateway;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;

@Configuration
public class ApiGatewayConfiguration {
	@Bean
	public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
		Function<PredicateSpec, Buildable<Route>> routeFunction = p -> p.path("/get")
				.filters(f -> f.addRequestHeader("MyHeader", "MyURI").addRequestParameter("Param", "MyValue"))
				.uri("http://httpbin.org:80");

		Function<PredicateSpec, Buildable<Route>> currencyExhcnageRoute = p -> p.path("/currency-exchange/**")
				.uri("lb://currency-exchange");

		Function<PredicateSpec, Buildable<Route>> currencyConversionRoute = p -> p.path("/currency-conversion/**")
				.uri("lb://currency-conversion");

		Function<PredicateSpec, Buildable<Route>> currencyConversionFeignRoute = p -> p
				.path("/currency-conversion-feign/**").uri("lb://currency-conversion");

		Function<PredicateSpec, Buildable<Route>> currencyConversionNewRoute = p -> p
				.path("/currency-conversion-new/**")
				.filters(f -> f.rewritePath("/currency-conversion-new/(?<segment>.*)",
						"/currency-conversion-feign/${segment}"))
				.uri("lb://currency-conversion");

		return builder.routes().route(routeFunction).route(currencyExhcnageRoute).route(currencyConversionRoute)
				.route(currencyConversionFeignRoute).route(currencyConversionNewRoute).build();
	}
}
