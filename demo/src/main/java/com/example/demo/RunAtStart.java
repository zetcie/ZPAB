package com.example.demo;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RunAtStart {
	private final EmployeeRopository employeeRepository;
	private final DepartmentRepository departmentRepository;

	@Autowired
	public RunAtStart(EmployeeRopository employeeRepository, DepartmentRepository departmentRepository) {
		super();
		this.employeeRepository = employeeRepository;
		this.departmentRepository = departmentRepository;
	}
	
	@PostConstruct
	public void runAtStart() {
		Department department = new Department();
        department.setDeptName("IT");
        departmentRepository.save(department);
        
        Department department2 = new Department();
        department2.setDeptName("HR");
        departmentRepository.save(department2);
		
		Employee employee = new Employee();
		employee.setFristName("Zofia");
		employee.setLastName("Cieplucha");
		employee.setSalary(new BigDecimal("5000"));
		employee.setEmploymentDate(LocalDate.of(2019,  05,  8));
		employee.setDepartment(department);
		employeeRepository.save(employee);
		
		Employee employee2 = new Employee();
		employee2.setFristName("Maria");
		employee2.setLastName("Kowalska");
		employee2.setSalary(new BigDecimal("6000"));
		employee2.setEmploymentDate(LocalDate.of(2019,  05,  3));
		employee2.setDepartment(department2);
		employeeRepository.save(employee2);
		
		Employee employee3 = new Employee();
		employee3.setFristName("Zofia");
		employee3.setLastName("Kowalska");
		employee3.setSalary(new BigDecimal("4000"));
		employee3.setEmploymentDate(LocalDate.of(2019,  05,  18));
		employee3.setDepartment(department2);
		employeeRepository.save(employee3);
		
		/*Iterable<Employee> zofias = employeeRepository.findByFristName("Zofia");
		Employee zofia = zofias.iterator().next();
		
		System.out.println("Zosia: "+zofia);
		
		for(Employee e: zofias) {
			System.out.println("Zosia: "+zofia);
		}*/
		
		Iterable<Employee> em = employeeRepository.findAllWhereName("K%");
		for(Employee e:em) {
			System.out.println(e);
		}
	
	}
}
