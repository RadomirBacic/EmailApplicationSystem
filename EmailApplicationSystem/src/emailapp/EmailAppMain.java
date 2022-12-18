package emailapp;

import java.util.Scanner;

public class EmailAppMain {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//User info
		System.out.println("Enter first name: ");
		String fName = sc.next();
		System.out.println("Enter last name: ");
		String lName = sc.next();
		
		//Creating object for email
		Email em1 = new Email(fName, lName);
		int choice = -1;
		
		do {
			System.out.println("\n ****** \n Enter your choice \n1.Show info \n2.Change password \n3.Set alternate email \n4.Exit ");
			choice = sc.nextInt();
			
			switch (choice) {
			case 1: 
				em1.getInfo();
				break;
			case 2:
				em1.changePassword();
				break;
			case 3:
				em1.alternateEmail();
				break;
			case 4:
				System.out.println("Thank you for using application!");
				break;
				
				default:
					System.out.println("Invalid choice,enter proper choice again:");
			}
				
			
		} while (choice!=4);
	}

	
	
	
	
}
