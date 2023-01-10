package com.example.demoJPA;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.hamcrest.Matchers;

import com.example.demoJPA.Entity.Employee;
import com.example.demoJPA.Repository.EmployeeRepo;
import com.example.demoJPA.Service.EmployeeService;

@SpringBootTest
class DemoJpaApplicationTests {
	@Autowired
	public EmployeeRepo repo;
	EmployeeService emps=new EmployeeService();

	@Test
	void contextLoads() {
	}
	@Test
	public void Empcheck() {
		boolean ans=false;
		boolean val;
		val=emps.checkName("seva","passsword");
		assertEquals(ans,val);
	}
	@Test
	public void EmpIdcheck() {
		Employee emp=repo.getById(12);
		
		assertNotEquals(emp,null);
		
	}

    
	   
}
