package com.exist.EmployeeAPI.employee;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public List<Employee> getEmployees() {
		return employeeRepository.findAll();
	}
	
	public Employee addEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	public Employee updateEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	public void deleteEmployee(Integer id) {
		Employee employee = employeeRepository.findById(id).get();
		employee.setTicketsAssigned(null);
		employee.setTicketsWatched(null);
		employeeRepository.deleteById(id);
	}
	
	public Employee getEmployeeById(Integer id) {
		Optional<Employee> employee = employeeRepository.findById(id);
		return employee.get();
	}

}
