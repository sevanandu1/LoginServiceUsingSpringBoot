package com.example.demoJPA.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Employee {
	
	@Id
	private int regn;

	private String username;
	private String password;
	public Employee(int regn, String username, String password) {
		super();
		this.regn = regn;
		this.username = username;
		this.password = password;
	}
	public Employee() {
		
	}
	public int getRegn() {
		return regn;
	}
	public void setRegN(int regn) {
		this.regn = regn;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Employee [regn=" + regn + ", username=" + username + ", password=" + password + "]";
	}
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}
