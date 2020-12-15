package com.example.demo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface DepartmentRepository extends CrudRepository<Department, Long>{
	//Iterable<Employee> findByFristName(String fristName);
		@Query("SELECT e FROM Department e WHERE e.deptName LIKE %?1")
		Iterable<Department> findAllWhereDeptName(String deptName);
}
