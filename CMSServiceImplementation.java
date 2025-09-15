package com.cms.service;

import static com.cms.exceptions.ValidationRulesCMS.ValidateAllInputs;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.cms.Comparators.compareByRegAmountComparator;
import com.cms.cores.Customer;
import com.cms.cores.ServicePlan;
//import com.cms.custom_exceptions.CMSHandlingException;
import com.cms.exceptions.CMSExecptionHandling;

public class CMSServiceImplementation implements CMSServiceLayer{
	List<Customer> customers = new ArrayList<>();
	
	public CMSServiceImplementation(List<Customer> customers){
		this.customers=customers;
		
		customers.add(new Customer("Shruti" , "Patil" , "shruti@gmail.com" , "Sh@123" , 2000 , LocalDate.of(2003, 10, 20) , ServicePlan.GOLD));
		customers.add(new Customer("Amit", "Sharma", "amit@gmail.com", "amit@123", 1000, LocalDate.of(1990, 5, 12),
				ServicePlan.SILVER));
		customers.add(new Customer("Priya", "Verma", "priya@gmail.com", "priya@123", 2000, LocalDate.of(1995, 8, 23),
				ServicePlan.GOLD));
		customers.add(new Customer("Rahul", "Patil", "rahul@yahoo.com", "rahul@123", 5000, LocalDate.of(1988, 1, 3),
				ServicePlan.DIAMOND));
		customers.add(new Customer("Sneha", "Kulkarni", "sneha@gmail.com", "sneha@123", 10000,
				LocalDate.of(1992, 11, 17), ServicePlan.PLATIUM));
		customers.add(new Customer("Vikas", "Rao", "vikas@gmail.com", "vikas@123", 2000, LocalDate.of(1998, 6, 29),
				ServicePlan.GOLD));
		customers.add(new Customer("Meera", "Joshi", "meera@gmail.com", "meera@123", 1000, LocalDate.of(2000, 2, 14),
				ServicePlan.SILVER));
		customers.add(new Customer("Arjun", "Deshmukh", "arjun@gmail.com", "arjun@123", 5000, LocalDate.of(1985, 9, 5),
				ServicePlan.DIAMOND));
		customers.add(new Customer("Kavya", "Iyer", "kavya@gmail.com", "kavya@123", 10000, LocalDate.of(1993, 12, 25),
				ServicePlan.PLATIUM));

	}

	@Override
	public String CustomerRegistration(String firstName, String lastName, String email, String password, int regAmount,
			String dob, String plan) throws CMSExecptionHandling{
          Customer c =ValidateAllInputs( firstName,  lastName,  email,  password,  regAmount,  dob, plan , customers) ; 
        
            customers.add(c);
            
		return "Successfull registration";
	}
	
	public void DisplayDetails() {
		for(Customer c : customers) {
			System.out.println(c);
		}
	}

	public Customer Sign(String email, String password) throws CMSExecptionHandling {
		/*
		 * 1.create customer reference to for identifying primary key
		 * 2.If primary key is found then get details
		 * 3.Compare stored password and Supplied password
		 */
		 Customer c = new Customer(email);
		 int index = customers.indexOf(c);
		 // if email not found throw exception
		 if(index == -1) throw new CMSExecptionHandling("Invalid Exception");
		 // if email found get details of the customer 
		 customers.get(index);
		 
		 // if email does not match 
		 Customer completeDetails = customers.get(index);
		 if(!completeDetails.getPassword().equals(password)) throw new CMSExecptionHandling("Invalid Password");
		
		
	
		return completeDetails ;
	}

	@Override
	public void ChangePassword( String email , String oldPassword, String newPassword) throws CMSExecptionHandling  {
		// create dummy object to identify the customer whose password should be changed 
		Customer c = Sign(email , oldPassword);
		c.setPassword(newPassword);
		
		System.out.println("Password Updated Successfully");
		
		
	}

	@Override
	public void Unsubscribe(String email) throws CMSExecptionHandling {
		Customer c = new Customer(email);
		int index = customers.indexOf(c);
		if(index == 0 ) throw new CMSExecptionHandling("No such email have subscribed , so refund not possible");
		customers.remove(c);
		
		System.out.println("User Unsubscribed !!");
		
	}

	@Override
	public void compareByRegAmount() {
		Collections.sort(customers, new compareByRegAmountComparator());
		
	}

	
	
}