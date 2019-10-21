package com.abhishek.dao;

import org.springframework.data.repository.CrudRepository;

import com.abhishek.entity.Ticket;


public interface TicketBookingRepository  extends CrudRepository<Ticket, Integer>{

}
