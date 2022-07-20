package com.microservices.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservices.service.bean.CurrencyExchange;

public interface ExchangeRateRepositry  extends JpaRepository<CurrencyExchange, Integer>{

	CurrencyExchange findByFromAndTo(String from,String to);
}
