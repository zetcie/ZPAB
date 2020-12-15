package com.example.demo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employees")
public class EmployeeApi {
	
	private EmployeeManager employeeManager;

	@Autowired
	public EmployeeApi(EmployeeManager employeeManager) {
		super();
		this.employeeManager = employeeManager;
	}
	
	@GetMapping("/all")
	public Iterable<Employee> getAll(){
		return employeeManager.findAll();
	}
	
	@GetMapping("/id")
	public Optional<Employee> findByID(@RequestParam Long id) {
		return employeeManager.findByID(id);
	}

	@PostMapping("/save")
	public Employee save(@RequestBody Employee employee) {
		return employeeManager.save(employee);
	}
	
	@DeleteMapping("/delete")
	public void deleteById(@RequestParam Long id) {
		employeeManager.deleteById(id);
	}
	
}
