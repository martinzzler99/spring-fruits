package com.example.service;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class RestSpringBootController {
	
	private static final Logger logger = LoggerFactory.getLogger(RestSpringBootController.class);
	
	@GetMapping("/hello")
	public String hello() {

		logger.trace("A TRACE Message");
        logger.debug("A DEBUG Message");
        logger.info("An INFO Message");
        logger.warn("A WARN Message");
        logger.error("An ERROR Message");
		
		return "Hello Spring";
	}
	
	@GetMapping(value = "/callclienthello")
	private String getHelloClient() {
		String uri = "http://localhost:8080/hello";
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(uri, String.class);
		return result;
	}
	
	@GetMapping(value = "/api/countries")
	private List<Object> getCountries() {
		String url = "https://restcountries.com/v2/all";
		RestTemplate restTemplate = new RestTemplate();
		
		Object[] countries = restTemplate.getForObject(url, Object[].class);
		
		return Arrays.asList(countries);
	}
	
	@GetMapping(value = "/api/crypto")
	private List<Object> getCrypto() {
		String url = "https://bitpay.com/api/rates";
		RestTemplate restTemplate = new RestTemplate();
		
		Object[] crypto = restTemplate.getForObject(url, Object[].class);

		return Arrays.asList(crypto);
	}
}
