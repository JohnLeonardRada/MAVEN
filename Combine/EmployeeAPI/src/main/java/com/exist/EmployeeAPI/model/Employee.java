package com.exist.EmployeeAPI.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.exist.EmployeeAPI.reference.Department;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "employees", uniqueConstraints = @UniqueConstraint(columnNames = {"employee_number"}))
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "employee_number", updatable = false)
	private Long employeeNumber;
	
	@Column(name = "first_name", nullable = false)
	private String firstName;
	
	@Column(name = "middle_name", nullable = false)
	private String middleName;
	
	@Column(name = "last_name",  nullable = false)
	private String lastName;
	
	@Column(name = "department", nullable = false)
	private Department department;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "assignee")
	Set<Ticket> ticketsAssigned;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "watchers")
	Set<Ticket> ticketsWatched = new HashSet<>();
	
	public void removeAssignTicket(Ticket ticket) {
		this.ticketsAssigned.remove(ticket);
		ticket.setAssignee(null);
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Long getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(Long employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Set<Ticket> getTicketsAssigned() {
		return ticketsAssigned;
	}

	public void setTicketsAssigned(Set<Ticket> ticketsAssigned) {
		this.ticketsAssigned = ticketsAssigned;
	}

	public Set<Ticket> getTicketsWatched() {
		return ticketsWatched;
	}

	public void setTicketsWatched(Set<Ticket> ticketsWatched) {
		this.ticketsWatched = ticketsWatched;
	}
	
}
