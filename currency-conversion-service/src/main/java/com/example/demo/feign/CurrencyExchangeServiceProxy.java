package com.example.demo.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.bean.CurrencyConversionBean;


@FeignClient(name="currency-exchange-service", url="localhost:8000")
public interface CurrencyExchangeServiceProxy {

	//copied from currency-exchange-service resource
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversionBean currencyExchange(
			@PathVariable String from
			,@PathVariable String to);
	
}
