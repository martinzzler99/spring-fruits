package com.example.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class RestSpringBootController {
	
	@RequestMapping("/hello")
	public String hello() {
		return "Hello world";
	}
	
	@GetMapping(value = "/callclienthello")
	private String getHelloClient() {
		String uri = "http://localhost:8080/hello";
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(uri, String.class);
		return result;
	}
	
	@GetMapping(value = "/countries")
	private List<Object> getCountries() {
		String url = "https://restcountries.com/v3.1/all";
		RestTemplate restTemplate = new RestTemplate();
		
		Object[] countries = restTemplate.getForObject(url, Object[].class);
		
		return Arrays.asList(countries);
	}
	
	@GetMapping(value = "/crypto")
	private List<Object> getCrypto() {
		String url = "https://bitpay.com/api/rates";
		RestTemplate restTemplate = new RestTemplate();
		
		Object[] crypto = restTemplate.getForObject(url, Object[].class);

		return Arrays.asList(crypto);
	}
}
