package com.exist.EmployeeAPI.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.exist.EmployeeAPI.model.Employee;
import com.exist.EmployeeAPI.service.EmployeeService;

@RestController
@CrossOrigin("*")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employees")
	public List<Employee> getEmployees(){
		return employeeService.getEmployees();
	}
	
	@PostMapping("/employees/addnew")
	@PreAuthorize("hasRole('ADMIN')")
	public Employee addEmployee(@RequestBody Employee employee) {
		employeeService.addEmployee(employee);
		return employee;
	}
	
	@PutMapping("/employees/{id}/edit")
	@PreAuthorize("hasRole('ADMIN')")
	public Employee updateEmployee(@PathVariable("id") Integer id, @RequestBody Employee employee) {
		employeeService.updateEmployee(employee);
		return employee;
	}
	
	@DeleteMapping("/employees/{id}/delete")
	@PreAuthorize("hasRole('ADMIN')")
	public void deleteEmployee(@PathVariable("id") Integer id) {
		employeeService.deleteEmployee(id);
	}
	
	@GetMapping("/employees/{id}")
	public Employee getEmployeeById(@PathVariable("id") Integer id) {
		return employeeService.getEmployeeById(id);
	}
}
