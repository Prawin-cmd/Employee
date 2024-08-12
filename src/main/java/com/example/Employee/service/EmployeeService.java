package com.example.Employee.service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.example.Employee.Exception.EmptyException;
import com.example.Employee.Exception.NameNotFound;
import com.example.Employee.dao.EmployeeDao;
import com.example.Employee.entity.Employee;

@Service
public class EmployeeService {
   @Autowired
   EmployeeDao ed;
   
   public String postThis(Employee e) {
	   return ed.postThis(e);
   }

public List<Employee> getThis() {
	 
	return ed.getThis();
}

public Employee getId(int a) {
	
	return ed.getId(a);
}

public String putThis(Employee e3) {
	
	return ed.putThis(e3);
}

public String deleteThis(int a) {
	return ed.deleteThis(a);
}

public List<Employee> getAll() {
	List<Employee> emp= ed.getThis().stream().filter(x->x.getSalary()>=40000).collect(Collectors.toList());
	return emp;
}

public List<Employee> secMax() {
	
	List<Employee> secmax= ed.getThis().stream().sorted(Comparator.comparingInt(Employee::getSalary).reversed()).distinct().limit(2).skip(1).collect(Collectors.toList());
    return secmax;
}

public List<Employee> getAges(int age) {
	return ed.getAges(age);
}

public List<Employee> getMaxi() {
	return ed.getMaxi();
}

public List<Object> getAgeSalary(int a,int b) {
	return ed.getAgeSalary(a,b);
}
public List<Object> getSss() {
	return ed.getSss();
}
public List<Employee> getAgeRange(int a,int b, int c) {
	return ed.getAgeRange(a, b, c);
}
public List<Employee> getjpAges( int a) {
	return ed.getjpAges(a);
}
public String getNameByid(int id) throws NameNotFound {
	if(ed.getNameByid(id).startsWith("S")) {
	   return ed.getNameByid(id);
	} else {
		throw new NameNotFound ("No name Found");
	}
}
public Employee getByName(String name) throws EmptyException {
	if(ed.getByName(name).isEmpty()) {
		throw new EmptyException("Not Found");
	}
	else {
		return ed.getByName(name).get();
	}
}

public String putByAge(Employee e1) throws EmptyException {
	if(e1.getAge()>18) {
		return ed.putByAge(e1);
	} else {
		throw new EmptyException("Age Not Eligible");
	}
}

public String putById(Employee eid,int id) {
	return ed.putById(eid,id);
}

public Optional<Object> findingbyid(int a) throws EmptyException {
	return Optional.of(ed.findingbyid(a)
			.orElseThrow(()-> new EmptyException("Object Not Present as Per ID")));
}
	

}
