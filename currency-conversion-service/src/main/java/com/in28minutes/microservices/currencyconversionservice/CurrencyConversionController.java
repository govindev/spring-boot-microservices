package com.in28minutes.microservices.currencyconversionservice;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CurrencyConversionController {
	@GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion retrieveConversion(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {

		RestTemplate restTemplate = new RestTemplate();
		String exchangeUri = "http://localhost:8000/from/" + from + "/to" + to;
		return new CurrencyConversion(1001, from, to, quantity, BigDecimal.ONE, BigDecimal.ONE, "");
	}

}
