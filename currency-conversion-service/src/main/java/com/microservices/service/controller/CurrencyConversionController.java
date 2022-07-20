package com.microservices.service.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.microservices.service.controller.bean.CurrencyConversion;
import com.microservices.service.proxy.CurrencyExchangeProxy;

@RestController
public class CurrencyConversionController {

	
	@Autowired
	CurrencyExchangeProxy proxy;
	
	@GetMapping("currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion calculateCurrencyConversion(@PathVariable String from, @PathVariable String to,
			@PathVariable String quantity) {

		HashMap<String, String> uriVariables = new HashMap<String, String>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);

		ResponseEntity<CurrencyConversion> responseEntity = new RestTemplate().getForEntity(
				"http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversion.class, uriVariables);

		CurrencyConversion currencyConv = responseEntity.getBody();
		int totalAmount = Integer.parseInt(quantity) * Integer.parseInt(currencyConv.getConversionMultiple());
		return new CurrencyConversion(currencyConv.getId(), from, to, currencyConv.getConversionMultiple(), quantity,
				totalAmount, currencyConv.getEnvironment());
	}
	
	@GetMapping("currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion calculateCurrencyConversionFeign(@PathVariable String from, @PathVariable String to,
			@PathVariable String quantity) {

		CurrencyConversion currencyConv = proxy.retrieveCurrencyExchange(from, to);
		int totalAmount = Integer.parseInt(quantity) * Integer.parseInt(currencyConv.getConversionMultiple());
		return new CurrencyConversion(currencyConv.getId(), from, to, currencyConv.getConversionMultiple(), quantity,
				totalAmount, currencyConv.getEnvironment()+" feign");
	}
}
