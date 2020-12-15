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
@RequestMapping("/api/departments")
public class DepartmentApi {
	
	private EmployeeManager employeeManager;

	@Autowired
	public DepartmentApi(EmployeeManager employeeManager) {
		super();
		this.employeeManager = employeeManager;
	}
	
	@GetMapping("/all")
	public Iterable<Department> getAll(){
		return employeeManager.findAllDepts();
	}
	
	@GetMapping("/id")
	public Optional<Department> findByID(@RequestParam Long id) {
		return employeeManager.findDeptByID(id);
	}

	@PostMapping("/save")
	public Department save(@RequestBody Department department) {
		return employeeManager.saveDept(department);
	}
	
	@DeleteMapping("/delete")
	public void deleteById(@RequestParam Long id) {
		employeeManager.deleteDeptById(id);
	}

}
