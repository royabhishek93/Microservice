package com.abhishek.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abhishek.entity.Ticket;
import com.abhishek.service.TicketBookingService;


@RestController
@RequestMapping(value="/api")
public class BookingController {

	@Autowired
	Environment environment;
	
	@Autowired
	private TicketBookingService ticketBookingService;
	
	@GetMapping("/backend")
	public String backend() {
		String serverPort = environment.getProperty("local.server.port");
		return "Hello form Backend!!! " + " Host : localhost " + " :: Port : " + serverPort;
	}
	
	@PostMapping(value="/create")
	public Ticket createTicket(@RequestBody Ticket ticket){
		return ticketBookingService.createTicket(ticket);
	}
	
	@GetMapping(value="/ticket/{ticketId}")
	//@RequestMapping(value="/ticket/{ticketId}")
	public Ticket getTicketById(@PathVariable("ticketId") Integer ticketId){
		return ticketBookingService.getTicketById(ticketId);
	}
	
	@GetMapping(value="/ticket/alltickets")
		public Iterable<Ticket> getAllBookedTickets(){
		return ticketBookingService.getAllBookedTickets();
	}
	
	@DeleteMapping(value="/ticket/{ticketId}")
	public void  deleteTicket(@PathVariable("ticketId")  Integer ticketId) {
		 ticketBookingService.deleteTicket(ticketId);
	}
	
	@PutMapping(value="/ticket/{ticketId}/{newEmail:.+}")
	public void  deleteTicket(@PathVariable("ticketId")  Integer ticketId,@PathVariable("newEmail")  String  newEmail) {
		 ticketBookingService.updateTicket(ticketId,newEmail);
	}
}
