package com.spring.ems.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.ems.entities.Employee;
import com.spring.ems.repository.EmployeeRepository;
import com.spring.ems.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public void addEmployee(Employee employee) {
		
		employeeRepository.save(employee);		
	}

	@Override
	public List<Employee> getAllEmployees() {
		
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(int id) {
		
		Optional<Employee> employee = employeeRepository.findById(id);
		if(employee.isPresent())
		{
			return employee.get();
		}
		return null;
	}

	@Override
	public void deleteEmployeeById(int id) {
		employeeRepository.deleteById(id);
		
	}

	
}
