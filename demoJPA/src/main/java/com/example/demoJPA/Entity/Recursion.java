package com.example.demoJPA.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Recursion {
	@Id
	private int n;

	public Recursion(int n) {
		super();
		this.n = n;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	public Recursion() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Recursion [n=" + n + "]";
	}
	

}
