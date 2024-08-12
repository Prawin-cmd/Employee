package com.example.Employee.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Employee.Exception.EmptyException;
import com.example.Employee.Exception.NameNotFound;
import com.example.Employee.entity.Employee;
import com.example.Employee.service.EmployeeService;


@RestController
public class EmployeeContoller {
	@Autowired
	EmployeeService es;

	@PostMapping(value = "/postEmp")
	public String postthis(@RequestBody Employee e) {
		return es.postThis(e);
	}
	
//	@PostMapping(value = "/postEmplist")
//	public String postlist(@RequestBody Employee e) {
//		return es.postlist(e);
//	}
	
	@GetMapping(value="/getEmp")
	public List<Employee> getThis() {
		return es.getThis();
	}
	
	@GetMapping(value="/getId/{a}")
	public Employee getId(@PathVariable int a) {
		return es.getId(a);
	}
	
	@PutMapping(value="/putEmp")
	public String putThis(@RequestBody Employee e3) {
		return es.putThis(e3);
	}
	
	@DeleteMapping(value="/deletebyId/{a}")
	public String deleteThis(@PathVariable int a) {
		return es.deleteThis(a);
	}
	
	@GetMapping(value="/getAll")
	public List<Employee> getAll() {
		return es.getAll();
	}
	
	@GetMapping(value="/getSecMax") 
	public List<Employee> getSecMax() {
		return es.secMax();
	}
	
	@GetMapping(value="/getAges/{age}")
	public List<Employee> getAges(@PathVariable int age) {
	     return es.getAges(age);
	}
	@GetMapping(value="/getMax")
	public List<Employee> getMaxi() {
		return es.getMaxi();
	}
	
	@GetMapping(value="/getAgeSalary/{a}/{b}")
	public List<Object> getAgeSalary(@PathVariable int a, @PathVariable int b) {
		return es.getAgeSalary(a,b);
	}
	@GetMapping(value="/getSs")
	public List<Object> getSss() {
		return es.getSss();
	}
	@GetMapping(value="/getAgeRange/{a}/{b}/{c}")
	public List<Employee> getAgeRange(@PathVariable int a,@PathVariable int b,@PathVariable int c) {
		return es.getAgeRange(a, b, c);
	}
	@GetMapping(value="/getJpAge/{a}")
	public List<Employee> getjpAges(@PathVariable int a) {
		return es.getjpAges(a);
	}
	@GetMapping(value="/getNameById/{id}")
	public String getNameByid(@PathVariable int id) throws NameNotFound {
		try{
			return es.getNameByid(id);
		} catch(NameNotFound ne) {
			return ne.getMessage();	
		  }
		}
	
	@GetMapping(value="/getByName/{name}")
	public Employee getByName(@PathVariable String name) throws EmptyException {
		return es.getByName(name);
	}
	
	@PutMapping(value="putByAge")
	public String putByAge(@RequestBody Employee e1) throws EmptyException {
		return es.putByAge(e1);
	}
	@PatchMapping(value="/putById/{id}")
	public String putById(@RequestBody Employee eid, @PathVariable int id) {
		return es.putById(eid,id);
	}
	
//	@GetMapping(value="/findingbyid/{a}")
//	public Optional<Object> findingbyid(@PathVariable int a) {
//		return es.findingbyid(a);
//	}
}
