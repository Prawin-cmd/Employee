package com.example.Employee.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.Employee.entity.Employee;
import com.example.Employee.repository.EmployeeRepository;

@Repository
public class EmployeeDao {
   @Autowired
   EmployeeRepository er;
   
   public String postThis(Employee e) {
	   er.save(e);
	   return "Posted Successfully";
   }

public List<Employee> getThis() {
	
	return er.findAll();
}

public Employee getId(int a) {
	
	return er.findById(a).get();
}

public String putThis(Employee e3) {
	
	 er.save(e3);
	 return "updated";
}

public String deleteThis(int a) {
	
	 er.deleteById(a);
	 return "Deleted";
}	 
public List<Employee> getAges(int age) {
	return er.getAges(age);
}

public List<Employee> getMaxi() {
	return er.getMaxi();
}

public List<Object> getAgeSalary(int a, int b) {
	return er.getAgeSalary(a,b);
}

public List<Object> getSss() {
	return er.getSss();
}

public List<Employee> getAgeRange(int a,int b, int c) {
	return er.getAgeRange(a, b, c);
}
public List<Employee> getjpAges(int a) {
	return er.getjpAges(a);
}

public String getNameByid(int id) {
	return er.findById(id).get().getName();
}  

//fromQuery
public Optional<Employee> getByName(String name) {
	return er.getByName(name);
}

public String putByAge(Employee e1) {
	er.save(e1);
	return "Uploded successfully";
}

public String putById(Employee eid, int id) {
	Employee x = er.findById(id).get();
	x.setAge(eid.getAge());
	er.save(x);
	
	return "Updated successfull";
}

public Optional<Employee> findingbyid(int a) {
	return er.findById(a);
}
}

