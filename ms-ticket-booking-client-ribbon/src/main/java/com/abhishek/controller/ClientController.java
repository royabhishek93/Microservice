package com.abhishek.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class ClientController {
	@LoadBalanced
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Autowired
	RestTemplate restTemplate;

	@GetMapping("/")
	    public String health() {
	        return "I am Ok";
	 }
	@RequestMapping("/client/frontend")
	public String hi() {
		String randomString = this.restTemplate.getForObject("http://TICKETSERVICE/backend", String.class);
		return "Server Response :: " + randomString;
	}
	
}
