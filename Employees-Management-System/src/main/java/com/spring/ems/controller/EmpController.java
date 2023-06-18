package com.spring.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.spring.ems.entities.Employee;
import com.spring.ems.service.EmployeeService;

import javax.servlet.http.HttpSession;

@Controller
public class EmpController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/")
	public String home(Model model) {
		
		List<Employee> employees = employeeService.getAllEmployees();
		model.addAttribute("emp",employees);
		return "index";
	}
	
	@GetMapping("/addemp")
	public String addEmp() {
		
		return "add_emp";
	}
	
	@PostMapping("/register")
	public String empRegister(@ModelAttribute Employee employee, HttpSession session) 
	{
		employeeService.addEmployee(employee);
		session.setAttribute("msg", "Employee added Sucessfully.. ");
		return "redirect:/";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id, Model model)
	{
		Employee employeeById = employeeService.getEmployeeById(id);
		model.addAttribute("emp", employeeById);
		return "edit";
	}
	
	@PostMapping("/update")
	public String updateEmployee(@ModelAttribute Employee employee, HttpSession session) 
	{
		employeeService.addEmployee(employee);
		session.setAttribute("msg", "Employee added Sucessfully.. ");
		return "redirect:/";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable int id, HttpSession session)
	{
		employeeService.deleteEmployeeById(id);
		session.setAttribute("msg", "Employee data deleted Sucessfully.. ");
		return "redirect:/";
	}
}
