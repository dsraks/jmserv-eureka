package com.dsr.humanres.ms.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dsr.humanres.ms.model.Employee;
import com.dsr.humanres.ms.service.EmployeesList;

@RestController
@RequestMapping("/humanres")
public class HumanResource {
	
	//Hardcoded list of employees
	List<Employee> employees = Arrays.asList(
		new Employee("E1", "Hari", "Prasad", "Cardiology"),
		new Employee("E2", "Vinod", "Kumar", "Oncology"),
		new Employee("E3", "Suresh", "Menon", "Paediatrics")
	);
	
	//getEmployees returns list of employees
	@RequestMapping("/employees")
	public EmployeesList getEmployees() {
		
		EmployeesList employeesList = new EmployeesList();
		employeesList.setEmployees(employees);		
		return employeesList;
	}
	
	//getEmployeeById returns an employee with the given Id
	@RequestMapping("/employees/{Id}")
	public Employee getEmployeeById(@PathVariable("Id") String Id) {
		Employee e = employees.stream()
				.filter(employee ->Id.equals(employee.getId()))
				.findAny()
				.orElse(null);
		return e;
	}
	
	//getEmployeeById returns an employee with the given Id
	@RequestMapping("/employee/{Id}")
	public EmployeesList getEmployeeDetailsById(@PathVariable("Id") String Id) {
		EmployeesList employeesList = new EmployeesList();
		List<Employee> femployees = employees.stream()
				.filter(emp ->Id.equals(emp.getId()))
				.collect(Collectors.toList());
		employeesList.setEmployees(femployees);
		return employeesList;
	}
}
