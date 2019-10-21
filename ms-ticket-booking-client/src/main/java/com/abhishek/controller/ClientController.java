package com.abhishek.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.abhishek.feignClient.BookingFeignCLient;


@RestController
public class ClientController {
	

	@Autowired
	BookingFeignCLient bookingFeignCLient;

	@GetMapping("/")
	    public String health() {
	        return "I am Ok";
	 }
	@RequestMapping("/client/frontend")
	public String hi() {
		String randomString = bookingFeignCLient.getData();
		return "Server Response :: " + randomString;
	}
	
}
