package emailapp;

import java.util.Random;
import java.util.Scanner;

public class Email {
	
	public Scanner sc = new Scanner(System.in);
	
	//Setting variables
	private String firstName;
	private String lastName;
	private String email;
	private String department;
	private String password;
	private int mailCapacity = 500;
	private String alterEmail;
	
	//Constructor to receive first name and last name.
	public Email(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		System.out.println("New employee: " + this.firstName + " " + this.lastName);
		
		//Calling methods
		this.department = this.setDepartment();
		this.password = this.generatePassword(8);//max 8 chars password
		this.email = this.generateEmail();
	}
	
	//Generate mail
	private String generateEmail() {
		return this.firstName.toLowerCase() + "." + this.lastName.toLowerCase() + "@" + this.department.toLowerCase() +  ".company.com";		
	}
	
	//Set department
	private String setDepartment() {
		System.out.println("Department codes \n1 for Sales \n2 for Development \n3 for Accounting \n0 none ");
		boolean var1 = false;
		
		do {
			System.out.println("Enter department code: ");
			int choice = sc.nextInt();
			
			switch (choice) {
			case 1:
				return "Sales";
			case 2:
				return "Development";
			case 3:
				return "Accounting";
			case 0:
				return "None";
			default:
				System.out.println("Invalid choice,please choose again!");
			}
		} while (!var1);
		return null;
	}
	
	//Generate random password
	private String generatePassword(int length) {
		
		Random random = new Random();
		String capitalChars = "ABCDEFGHIJKLMNOPRSTUVWZYZ";
		String smallChars = "abcdefghijklmnoprstuvwxyz";
		String numbers = "0123456789";
		String symbols = "!@#%&?";
		String values = capitalChars + smallChars + numbers + symbols;
		
		for (int i = 0; i < length; i++) {
			password = password + values.charAt(random.nextInt(values.length()));
		}
		return password;
		
	}
	
	//Change password
	public void changePassword() {
		boolean var1 = false;
		
		do {
			System.out.println("Do you want to change your password? (Y/N)");
			char choice = sc.next().charAt(0);
			if (choice == 'Y' || choice == 'y') {
				var1 = true;
				System.out.println("Enter current password: ");
				String yourPassword = sc.next();
				if (yourPassword.equals(this.password)) {
					System.out.println("Enter new password: ");
					this.password = sc.next();
					System.out.println("Password changed successfully.");
				}else {
					System.out.println("Incorrect password");
			}
			}else if (choice == 'N' || choice == 'n') {
				var1 = true;
				System.out.println("Password changed option cancelled!");
			}else {
				System.out.println("Enter valid choice");
			}
	
	}while(!var1);
}	
	
	//Set alternate email
	public void alternateEmail() {
		System.out.println("Enter new alternate email: ");
		this.alterEmail = sc.next();
		System.out.println("Alternate email is set");
	}
	
	//Display user information
	public void getInfo() {
		System.out.println("New: " + this.firstName + " " + this.lastName);
		System.out.println("Department: " + this.department);
		System.out.println("Email: " + this.email);
		System.out.println("Password: " + this.password);
		System.out.println("Mailbox capacity: " + this.mailCapacity);
		System.out.println("Alternate email: " + this.alterEmail);
	}
	
	
	
	
	
	
	
}
