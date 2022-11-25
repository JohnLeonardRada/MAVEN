package com.exist.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.exist.reference.Severity;
import com.exist.reference.Status;

@Entity
@Table(name = "tickets")
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ticketId;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "severity")
	private Severity severity;
	
	@Column(name = "status")
	private Status status;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "assignee_id", referencedColumnName = "id")
	private Employee assignee;
	
	@ManyToMany
	@JoinTable(name = "watchers",
			joinColumns = @JoinColumn(name = "ticket_id"),
			inverseJoinColumns = @JoinColumn(name = "employee_id")
	)
	Set<Employee> watchers = new HashSet<>();
	
	public void removeAssignTicket(Ticket ticketId) {
		this.assignee.removeAssignTicket(ticketId);
	}
	
	public void removeWatcher(Integer id) {
		this.watchers.removeIf(employee -> employee.getId() == id);
	}
	
	public Integer getTicketId() {
		return ticketId;
	}

	public void setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Severity getSeverity() {
		return severity;
	}

	public void setSeverity(Severity severity) {
		this.severity = severity;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Employee getAssignee() {
		return assignee;
	}

	public void setAssignee(Employee assignee) {
		this.assignee = assignee;
	}

	public Set<Employee> getWatchers() {
		return watchers;
	}

	public void setWatchers(Set<Employee> watchers) {
		this.watchers = watchers;
	}
	
}