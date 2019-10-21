package com.abhishek.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="TICKET-SERVICE")
public interface BookingFeignCLient {

	@GetMapping(value="/backend")
	public String getData();
}
