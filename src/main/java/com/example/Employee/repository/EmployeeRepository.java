package com.example.Employee.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.Employee.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer>  {

	@Query (value= "Select * from employee where age > ?", nativeQuery= true)
	public List<Employee> getAges(int age);
	
	@Query (value= "Select * from employee where salary= (select max(Salary) from employee)", nativeQuery= true)
	public List<Employee> getMaxi();
    
	@Query (value="Select name,salary from employee where age>?  and salary>? ", nativeQuery=true)
	public List<Object> getAgeSalary(int a,int b);
	
	@Query (value="select name from employee where name like 's%'", nativeQuery=true)
	public List<Object> getSss();
	
	@Query (value="select * from employee where age>? and age<? and salary>?", nativeQuery=true)
	public List<Employee> getAgeRange(int a,int b,int c);
	
//Jpa-Query
	@Query (value="select a from Employee a where a.age>:age")
	public List<Employee> getjpAges(@Param("age") int a);
//NativeQuery	
	@Query (value="select * from employee where name like ?", nativeQuery=true)
	public Optional<Employee> getByName(String name);
	
}
