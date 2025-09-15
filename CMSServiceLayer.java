package com.cms.service;

import com.cms.cores.Customer;
import com.cms.exceptions.CMSExecptionHandling;

import com.cms.Comparators.compareByRegAmountComparator;
public interface CMSServiceLayer{
	public  String CustomerRegistration(String firstName, String lastName, String email, String password, int regAmount, String dob,
			String plan ) throws CMSExecptionHandling;
	
	public void DisplayDetails();

	public Customer Sign(String email, String password) throws CMSExecptionHandling;

	public void ChangePassword( String email , String oldPassword, String newPassword) throws CMSExecptionHandling;

	public void Unsubscribe(String email) throws  CMSExecptionHandling;

	//public void compareBasedOnServicePlan();

	public void compareByRegAmount();

	
}