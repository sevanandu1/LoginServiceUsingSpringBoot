package com.example.demoJPA.Service;

import java.util.ArrayList;
import java.util.Optional;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demoJPA.Entity.Employee;
import com.example.demoJPA.Repository.EmployeeRepo;

@Service
public class EmployeeService {
	
	@Autowired
	public EmployeeRepo repo;
	@Autowired 
	public Employee emp;
	
	public void save(Employee emp) {
		repo.save(emp);
	}
	public static Employee saveEmployee(Employee emp) {
		emp.setRegN(1);
		emp.setUsername("seva");
		emp.setPassword("password");
		return emp;
	}
	public boolean checkbyId(int id) {
		Employee emp=repo.getById(id);
		if(emp==null) {
			return true;
		}
		return false;
	}
	public boolean checkName(String name,String pass) {
		if(name.equalsIgnoreCase("seva") && pass.equalsIgnoreCase("password")) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean checkbyName(String name,String password) {
		Optional<Employee> opt=repo.findByUsername(name);
		Employee emp=opt.get();
		System.out.println(emp.getUsername()+""+emp.getPassword()+" "+emp.getRegn());
		if(emp.getUsername().equalsIgnoreCase(name) && emp.getPassword().equalsIgnoreCase(password)) {
			return true;
		}
		return false;
	}
	
	public boolean valid() {
		long emp=repo.count();
		
		if(emp==0) {
			return false;
		}
		return true;
	}
	public int recur(int n) {
		if(n<=1) {
			return 1;
		}
		return n*recur(n-1);
	}
	
	

}
