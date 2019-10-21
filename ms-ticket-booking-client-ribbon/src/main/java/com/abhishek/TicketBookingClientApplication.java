package com.abhishek;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

import com.abhishek.ribbonConfig.RibbonConfiguration;



@EnableDiscoveryClient
@SpringBootApplication
@RibbonClient(name = "ticketService", configuration = RibbonConfiguration.class)
public class TicketBookingClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(TicketBookingClientApplication.class, args);
	}

}
