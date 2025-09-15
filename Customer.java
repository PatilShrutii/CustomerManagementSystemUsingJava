package com.cms.cores;

import java.time.LocalDate;


public class Customer implements Comparable<Customer>{
	// data members 
	static int custId ;
	private String firstName , lastName ;
	private String email , password ;
	private int regAmount;
	

	public void setRegAmount(int regAmount) {
		this.regAmount = regAmount;
	}

	private LocalDate dob ;
	private ServicePlan plan;


	// static initalizer block
	static {
		custId = 1000 ;
	}
	//Constructor
	
	public Customer(String firstName, String lastName, String email, String password, int regAmount, LocalDate dob,
			ServicePlan plan) {
		super();
		custId = ++custId ;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.regAmount = regAmount;
		this.dob = dob;
		this.plan = plan;
	}
	
	public  Customer(String email){
		this.email = email;
	}
    public Customer(String firstName2, String lastName2) {
    	this.firstName = firstName ;
		this.lastName = lastName ;
	}

	// methods 
	// getter for email , dob
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	// toString  ----- overrided from string class
	@Override
	public String toString() {
		return "[First Name -  " + firstName + "Last name - " + lastName + "Email - " + email + "Register Amount - " + regAmount + "Date of birth " + dob + "Service plan - " + plan + " ]";
		
	}
	
	// equals method ----- override from String class 
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof  Customer) {
			Customer c=(Customer)obj;
			return this.email.equals(c.email);
		}
		return false ;
	}
	
	// sort using comparable
	@Override
	public int compareTo(Customer anotherObj) {
		return this.email.compareTo(anotherObj.email);
		
	}

	public int getRegAmount() {
		// TODO Auto-generated method stub
		return regAmount;
	}

	
	
	
	
}
