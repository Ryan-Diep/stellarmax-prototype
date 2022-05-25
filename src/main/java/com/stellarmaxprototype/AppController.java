package com.stellarmaxprototype;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class AppController {

	@Autowired
	private EmployeeRepository repository;
	
	@GetMapping("")
	public String viewHomePage() {
		return "index";
	}
	
//	public Employee addEmployee(@RequestBody Employee employee) {
//		return repository.save(employee);
//	}
	
//	@PostMapping("/employee")
//	public static void main(String[] args) {
//		SpringApplication.run(StellarmaxprototypeApplication.class, args);
//	}
//	
//	@GetMapping("/employees")
//	public List<Employee> getEmployees(){
//		return repository.findAll();
//	}
}
