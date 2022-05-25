package com.stellarmaxprototype;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class StellarmaxprototypeApplication {

	@Autowired
	private EmployeeRepository repository;
	
	public Employee addEmployee(@RequestBody Employee employee) {
		return repository.save(employee);
	}
	
	@PostMapping("/employee")
	public static void main(String[] args) {
		SpringApplication.run(StellarmaxprototypeApplication.class, args);
	}
	
	@GetMapping("/employees")
	public List<Employee> getEmployees(){
		return repository.findAll();
	}
}
