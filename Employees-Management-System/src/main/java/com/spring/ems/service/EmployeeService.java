package com.spring.ems.service;

import java.util.List;

import com.spring.ems.entities.Employee;


public interface EmployeeService {

	public void addEmployee(Employee employee);
	
	public List<Employee> getAllEmployees();
	
	public Employee getEmployeeById(int id);
	
	public void deleteEmployeeById(int id);
}
