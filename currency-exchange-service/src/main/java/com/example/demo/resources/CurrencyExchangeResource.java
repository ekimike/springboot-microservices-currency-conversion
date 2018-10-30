package com.example.demo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.ExchangeValue;
import com.example.demo.repository.ExchangeValueRepository;

@RestController
public class CurrencyExchangeResource {
	
	@Autowired
	private Environment env;
	
	@Autowired
	private ExchangeValueRepository valueRepository;

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue currencyExchange(
			@PathVariable("from") String from
			,@PathVariable("to") String to) {
		
		
		
		ExchangeValue exchangeValue = valueRepository.findByFromAndTo(from, to);
		exchangeValue.setPort(Integer.parseInt(env.getProperty("local.server.port")));
		
		return exchangeValue;
	}
}
