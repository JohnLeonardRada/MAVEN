package com.exist.EmployeeAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exist.EmployeeAPI.model.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer>{
	
}
