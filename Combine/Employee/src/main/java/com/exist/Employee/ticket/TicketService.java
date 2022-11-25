package com.exist.Employee.ticket;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exist.Employee.employee.Employee;
import com.exist.Employee.employee.EmployeeRepository;

@Service
public class TicketService {
	
	@Autowired
	private TicketRepository ticketRepository;
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public List<Ticket> getTickets(){
		return ticketRepository.findAll();
	}
	
	public Ticket addTicket(Ticket ticket) {
		return ticketRepository.save(ticket);
	}
	
	public Ticket updateTicket(Ticket ticket) {
		return ticketRepository.save(ticket);
	}
	
	public void deleteTicket(Integer ticketId) {
		Ticket ticket = ticketRepository.findById(ticketId).get();
		if(ticket.getAssignee() != null) {
			ticket.getAssignee().removeAssignTicket(ticket);
		}
		ticket.setAssignee(null);
		ticket.setWatchers(null);
		ticketRepository.save(ticket);
		ticketRepository.deleteById(ticketId);
	}
	
	public Ticket addAssignee(Integer ticketId, Integer id) {
		Ticket ticket = ticketRepository.findById(ticketId).get();
		Employee employee = employeeRepository.findById(id).get();
		ticket.setAssignee(employee);
		return ticketRepository.save(ticket);
	}
	
	public Ticket addWatcher(Integer ticketId, Integer id) {
		Ticket ticket = ticketRepository.findById(ticketId).get();
		Employee employee = employeeRepository.findById(id).get();
		ticket.watchers.add(employee);
		return ticketRepository.save(ticket);
	}
	
	public void removeAssignee(Integer ticketId, Integer id) {
		Ticket ticket = ticketRepository.findById(ticketId).get();
		ticket.removeAssignTicket(ticket);
		ticketRepository.save(ticket);
	}
	
	public void removeWatcher(Integer ticketId, Integer id) {
		Ticket ticket = ticketRepository.findById(ticketId).get();
		ticket.removeWatcher(id);
		ticketRepository.save(ticket);
	}
}
