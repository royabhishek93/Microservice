package com.abhishek.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhishek.dao.TicketBookingRepository;
import com.abhishek.entity.Ticket;


@Service
public class TicketBookingService {
	@Autowired
	private TicketBookingRepository ticketBookingDao;
	
	public Ticket createTicket(Ticket ticket) {
		return ticketBookingDao.save(ticket);
	}
	public Ticket getTicketById(Integer ticketId) {
		return ticketBookingDao.findById(ticketId).orElse(null);
	}
	
	public Iterable<Ticket> getAllBookedTickets() {
		return ticketBookingDao.findAll();
	}
	public void deleteTicket(Integer ticketId) {
		// TODO Auto-generated method stub
		 ticketBookingDao.deleteById(ticketId);
	
	}
	
	public Ticket updateTicket(Integer ticketId, String newEmail) {
		Ticket ticketFromDB=ticketBookingDao.findById(ticketId).orElse(null);
		ticketFromDB.setEmail(newEmail);
		Ticket updateTicket=ticketBookingDao.save(ticketFromDB);
		return updateTicket;
		
		
		
	}
	
}
