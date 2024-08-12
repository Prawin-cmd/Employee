package com.example.webApp;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping(value="/webapp")
public class webAppController {
	
	@GetMapping(value="/get")
     public String getThis() {
    	 return "Hello World";
     }
	
	@GetMapping(value="/name/{a}/{b}")
	public String getName(@PathVariable String a,@PathVariable String b) {
		return a.concat(b);
	} 
	
	@GetMapping(value="/rev/{c}")
	public String rev(@PathVariable String c) {
		String temp="";
	    for(int i=c.length()-1;i>=0;i--) {
			temp=temp+c.charAt(i);    
		}
	     return temp;
	}
	
	@GetMapping(value="/prime/{a}/{b}")
	public ArrayList<Integer> prime(@PathVariable int a,@PathVariable int b) {
		  ArrayList<Integer> prime= new ArrayList<>();
		   for(int i=a;i<=b;i++) {
			  boolean istrue=true;
			  for(int j=2;j<i;j++) {
				  if(i%j==0) {
					 istrue=false;
				  }
			  }
			  if(istrue==true) {
				  prime.add(i);
			  }
		  }  
		  
		  return prime;
	}
	
	@GetMapping(value="/getCar")
	public Car getCar(@RequestBody Car car) {
		return  car;
	}
	
	@GetMapping(value="/getCarlist")
	public List<Car> getCarlist(@RequestBody List<Car> car) {
		 return  car;	
	}
	
	@GetMapping(value="/getprice")
	public int getprice(@RequestBody Car car) {
		return  car.getPrice();
	}
	
	@GetMapping(value="/getpricerange")
	public List<Car> getCarpricelist(@RequestBody List<Car> car) {
		 return  car.stream().filter(x->x.getPrice()>200000 && x.getPrice()<300000).collect(Collectors.toList());	
	}
	
	@GetMapping(value="/pricediscount")
	public Car getdiscount(@RequestBody Car car) {
		 car.setPrice(car.getPrice()+500);
		 return car;
	}
	
	@GetMapping(value="/DateFormate/{date}")
	public String getDate(@PathVariable String date) {
		String format= convertDate(date);
		return format;
	} 
		public static String convertDate(String a) {
			DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("dd MMMM, yyyy");
			DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			
			try {
				LocalDate date= LocalDate.parse(a, inputFormat);
				String format= date.format(outputFormat);
				return format;
			} catch (DateTimeParseException e) {
				return "Parsing Date: "+e.getMessage();
			}
		
	}
		
	    @GetMapping(value="/lowUp/{name}") 
		public String getlowUp(@PathVariable String name) {
			String result =appString(name);
			return result;
		}
		
		public static String appString(String a) {
			 Map<Character, Long> caseCount = a.chars()
			            .mapToObj(c -> (char) c)
			            .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
			   
			   StringBuilder res = new StringBuilder();
			   
			    caseCount.entrySet().stream().filter(c->c.getKey().isLowerCase(c.getKey()))
		       .filter( x -> x.getValue() > 1)
		       .forEach(x -> res.append(x.getKey()));
			    
			    caseCount.entrySet().stream().filter(c->c.getKey().isUpperCase(c.getKey()))
			       .filter( x -> x.getValue() == 1)
			       .forEach(x -> res.append(x.getKey()));
			    
			    return res.toString();
		}
		
		@GetMapping(value="/getAccess")
		public String getThis(@RequestParam String name, @RequestParam String password) {
			if(name.equals("prawin") && password.equals("prawin123")) {
				return "Access successfully";
			} else {
				return "Access denied";
			}
		}
}



