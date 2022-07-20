package com.microservices.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.service.bean.CurrencyExchange;
import com.microservices.service.repository.ExchangeRateRepositry;

@RestController
public class CurrencyExchangeController {

	@Autowired
	Environment env;
	
	@Autowired
	ExchangeRateRepositry repository;
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange retrieveCurrencyExchange(
			@PathVariable String from, @PathVariable String to) {
	String port = env.getProperty("local.server.port");
	CurrencyExchange currencyExchange = repository.findByFromAndTo(from, to);
	
	
	currencyExchange.setEnvironment(port);
		return currencyExchange;
	}
}
