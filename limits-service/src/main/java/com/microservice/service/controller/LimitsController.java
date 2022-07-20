package com.microservice.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.service.configuration.Configuration;
import com.microservice.service.controller.bean.Limits;

@RestController
public class LimitsController {

	@Autowired
	Configuration config;
	
	@GetMapping("/limits")
	public Limits retrieveLimits() {
		return new Limits(config.getMinimum(),config.getMaximum());
	}
}
