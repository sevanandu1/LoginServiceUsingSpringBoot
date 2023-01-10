package com.example.demoJPA.Repository;

import org.springframework.stereotype.Repository;
import com.example.demoJPA.Entity.Employee;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Integer> {
	//Employee getByUserName(String name);
	Optional<Employee> findByUsername(String name);

}
