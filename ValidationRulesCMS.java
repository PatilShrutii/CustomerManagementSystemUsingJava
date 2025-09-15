package com.cms.exceptions;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.cms.cores.Customer;
import com.cms.cores.ServicePlan;

public class ValidationRulesCMS extends CMSExecptionHandling{
	public ValidationRulesCMS(String errMSg) {
		super(errMSg);
		// TODO Auto-generated constructor stub
	}

	
	List<Customer> customersList = new ArrayList<>();
	public static Customer ValidateAllInputs(String firstName, String lastName, String email, String password, int regAmount, String dob,String plan , List<Customer> customers) throws CMSExecptionHandling {
		ValidateEmailAsperRegularExp( email);
		StrongPasswordReqired(email , password);
		DuplicateEmail(email, password) ;
		ServicePlan service = ParseAndValidatePlanAndRegAmount(plan , regAmount);
		
		
		
		return new Customer( firstName,  lastName,  email,  password, regAmount, LocalDate.parse(dob),
			ServicePlan.valueOf(plan) );
	}
	
	
	



	private static void StrongPasswordReqired(String email , String password) throws CMSExecptionHandling {
		String strongPasswordReg = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$\r\n";
		Customer c = new Customer(email);
		if(!c.getPassword().matches(strongPasswordReg)) throw new CMSExecptionHandling("Create a strong password , a password must contain atleast one uppercase , one lower case , one digit , and one special carector");
		
		System.out.println("Strong password created successfully");

		
	}






	private static void ValidateEmailAsperRegularExp(String email) throws CMSExecptionHandling{
		Customer c = new Customer(email);
		String regExp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{3,}$\r\n";
		if(! c.getEmail().matches(regExp)) throw new CMSExecptionHandling("Email format is incorrect"); 
		
		System.out.println("Email Validated Successfully");
	}


	public static String DuplicateEmail(String email, String password) throws  CMSExecptionHandling{
		Customer c = new Customer(email);
		if(c.equals(email)) throw new CMSExecptionHandling("Invalid Email");
		return "Successfull Validation of Email";
		
	}
	
	
	public static ServicePlan ParseAndValidatePlanAndRegAmount(String plan , int regAmount) throws CMSExecptionHandling
 {
		ServicePlan servicePlan = ServicePlan.valueOf(plan);
		if(servicePlan.ordinal()!= regAmount) throw new CMSExecptionHandling("Registration amount and serive plan don't match , Contact customer service asap ");
			
		
		
		return servicePlan;
		
	}
}