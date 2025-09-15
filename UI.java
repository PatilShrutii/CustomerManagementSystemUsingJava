package cms.developers.tester;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.cms.cores.Customer;
import com.cms.service.CMSServiceImplementation;
import com.cms.service.CMSServiceLayer;


public class UI {

	public static void main(String[]  args) {
		boolean exit = false;
		List<Customer> customers = new ArrayList<>(1024);
	
		try(Scanner sc = new Scanner(System.in)){
		System.out.println("Enter number of elements - ");
		CMSServiceLayer service = new CMSServiceImplementation(customers);
		while(!exit) {
		System.out.println("1. register customer \n 2. display \n 3. Login and authentication \n"
				+ " 4. Change Password \n 5. Unsubscribe \n  6. Sort on the basis of email \n"
				+ " 7. sort on the basis of Service Plan \n 8. Sort on the basis Plan and Reg Amount ranging from high to low \n"
				+ " 0. exit");
		try {
			System.out.println("Enter your choice : ");
			switch(sc.nextInt()) {
		
			case 1:
				System.out.println("Enter customer details in order  firstName,  lastName,  email,  password,  regAmount,dob,  plan");
                System.out.println("Status - " + service.CustomerRegistration(sc.next(), sc.next(), sc.next() , sc.next() , sc.nextInt() , sc.next(), sc.next()));
                
                break;
			    
			case 2 :
				// display 
				System.out.println("Display Details - ");
				service.DisplayDetails();
				  
				break;
				
			case 3 : 
				// login and authentication 
//				
				System.out.println("Enter email and password for login - ");
				service.Sign(sc.next(), sc.next());
				break;
				
				
			case 4:
				// change password 
				System.out.println("Enter email whose password is to be changed along with  old password and new password - ");
				service.ChangePassword(sc.next() , sc.next(), sc.next());
				break;
				
			case 5:
				// unsubscribe 
				System.out.println("Enter the email you want to unsubscribe from - ");
				service.Unsubscribe(sc.next());
				break; 
				
			case 6:
				//Sort on the basis of email 
				System.out.println("Sorted list of customers based on emails - ");
			    Collections.sort(customers);
				break;
				
			case 7:
				//sort on the basis of Service Plan
				System.out.println("sort on the basis of Service Plan - ");
				service.compareByRegAmount();
				break;
				
			case 0: 
				exit = true ;
				break;
				
			}
		}catch(Exception e) { 
			e.printStackTrace();
		}
		sc.nextLine();
	}
	}

	}}
