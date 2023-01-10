package com.example.demoJPA.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demoJPA.Entity.Employee;
import com.example.demoJPA.Service.EmployeeService;
import java.io.*;  
  

@Controller
public class EmployeeController {
	
	@Autowired
	public EmployeeService emps;
	
	
	public EmployeeController() {
		
		
	}
	@RequestMapping(value="login",method=RequestMethod.GET)
	public String logins(ModelMap model) {
		
		if(emps.valid()) {
		return "login";
		}
		
		
		model.addAttribute("errorMessage","No credential listed goto regester page to regester");
		return "redirect:/login";
		
	    
	}
	@RequestMapping(value="regester",method=RequestMethod.GET)
	public String reg() {
		return "regester";
	}
	@RequestMapping(value="welcome",method=RequestMethod.GET)
	public String welc() {
		return "welcome";
	}
	
	
	@RequestMapping(value="login",method=RequestMethod.POST)
	public String Details(@RequestParam String username,@RequestParam String password,ModelMap model) {
		
		model.put("username",username);
		model.put("password",password);
		
		if(emps.checkbyName(username, password)) {
			return "redirect:/welcome";
		}
		
	    model.addAttribute("errorMesage", "Invalid credential");
		return "redirect:/login";
		
		
	}
	@RequestMapping(value="/regester",method=RequestMethod.POST)
	//@PostMapping("/login")
	public String loginw(@RequestParam int regn,@RequestParam String username,@RequestParam String password,ModelMap model) {
		if(!emps.valid()) {
			
			model.put("errorMessage","Seems to be there are no usernames to login please create one");
			}
			
		
		Employee stu=new Employee(regn,username,password);
		
		model.put("regn",regn);
		
		model.put("username",username);
		
		model.put("password",password);
		
		model.addAttribute("stu",stu);
		
		
		emps.save(stu);
		return "redirect:/login";
		
		
	}
	@RequestMapping(value="/recursion",method=RequestMethod.POST)
	public String recu(@RequestParam int val,ModelMap model) {
		model.put("val", val);
		int va=emps.recur(val);
		model.put("mes","value is"+va);
		return "recursion";
		
	}
	@RequestMapping(value="recursion",method=RequestMethod.GET)
	public String recus() {
		
		return "recursion";
		
	}



}
