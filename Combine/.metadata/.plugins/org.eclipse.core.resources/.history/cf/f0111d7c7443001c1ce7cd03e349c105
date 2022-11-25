package com.exist.Employee.ticket;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class TicketController {
	
	@Autowired
	private TicketService ticketService;
	
	@GetMapping("/tickets")
	public List<Ticket> getTicket(){
		return ticketService.getTickets();
	}
	
	@PostMapping("/tickets/addnew")
	@PreAuthorize("hasRole('ADMIN')")
	public Ticket addTicket(@RequestBody Ticket ticket) {
		ticketService.addTicket(ticket);
		return ticket;
	}
	
	@PutMapping("/tickets/{id}/edit")
	@PreAuthorize("hasRole('ADMIN')")
	public Ticket updateTicket(@PathVariable("id") Integer id, @RequestBody Ticket ticket) {
		ticketService.updateTicket(ticket);
		return ticket;
	}
	
	@DeleteMapping("/tickets/{id}/delete")
	@PreAuthorize("hasRole('ADMIN')")
	public void deleteTicket(@PathVariable("id") Integer id) {
		ticketService.deleteTicket(id);
	}
	
	@PutMapping("/tickets/assign")
	@PreAuthorize("hasRole('ADMIN')")
	public Ticket addAssignee(@RequestParam Integer ticketId, @RequestParam Integer id) {
		return ticketService.addAssignee(ticketId, id);
	}
	
	@PutMapping("/tickets/assignWatcher")
	@PreAuthorize("hasRole('ADMIN')")
	public Ticket addWatcher(@RequestParam Integer ticketId, @RequestParam Integer id) {
		return ticketService.addWatcher(ticketId, id);
	}
	
	@DeleteMapping("/tickets/removeAssignee")
	@PreAuthorize("hasRole('ADMIN')")
	public void removeAssignee(@RequestParam Integer ticketId, @RequestParam Integer id) {
		ticketService.removeAssignee(ticketId, id);
	}
	
	@DeleteMapping("/tickets/removeWatcher")
	@PreAuthorize("hasRole('ADMIN')")
	public void removeWatcher(@RequestParam Integer ticketId, @RequestParam Integer id) {
		ticketService.removeWatcher(ticketId, id);
	}
}
