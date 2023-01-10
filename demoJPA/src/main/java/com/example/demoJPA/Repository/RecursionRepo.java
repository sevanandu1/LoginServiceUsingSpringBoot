package com.example.demoJPA.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demoJPA.Entity.Recursion;
@Repository
public interface RecursionRepo extends JpaRepository<Recursion,Integer>{

}
