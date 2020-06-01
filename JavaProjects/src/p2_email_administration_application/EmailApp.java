package p2_email_administration_application;

import java.util.Scanner;

public class EmailApp {

	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);

		System.out.println("Welcome to Team Tristan! Please type in your first name.");
		String f = stdin.next();
		
		System.out.println("Hello, " + f + "! Please type in your last name.");
		String l = stdin.next();
		
		System.out.println("Are you in sales, development, or accounting?");
		System.out.println("Click 1 for sales, 2 for development, 3 for accounting, or 0 for none.");
		int d;
		
		if(stdin.hasNextInt()) {
			d = stdin.nextInt();
		}
		else {
			d = 0;
			stdin.nextLine();
			System.out.println("This input is not valid, you may change departments later.");
		}
		
		Employee e1 = new Employee(f, l);
		
		e1.setDepartment(d);
		e1.generatePassword();
		e1.createEmail();
		
		System.out.println("Your new email is " + e1.getEmail() );
		System.out.println("Your new password is " + e1.getPassword() );
		System.out.println("Your default mailbox capacity is " + e1.getMailbox() );
			
		int change = 1;
		do {
			System.out.println("=========================================================================================");
			System.out.println("Is there anything else, " + e1.getFirstName() + "?");
			System.out.println("Press 1 to change departments, 2 to change password, 3 to change mailbox ");
			System.out.println("capacity, 4 to change email, 5 to view current info, -1 to exit.");
			System.out.println("=========================================================================================");
			
			if(stdin.hasNextInt()) {
				change = stdin.nextInt();
			}
			else {
				stdin.nextLine();
				System.out.println("This input is not valid, you may change departments later.");
			}
			
			switch(change){
				case 1:
					System.out.println("What deparment would you like to change to?");
					System.out.println("Click 1 for sales, 2 for development, 3 for accounting, or 0 for none.");
					if(stdin.hasNextInt()) {
						d = stdin.nextInt();
					}
					else {
						stdin.nextLine();
						System.out.println("This input is not valid, you may change departments later.");
						break;
					}
					
					e1.setDepartment(d);
					if(e1.getDepartment().equals(""))
						System.out.println("You are no longer in a department.");
					else
						System.out.println("Your department is now " + e1.getDepartment() + ".");
					break;
			
				case 2:
					System.out.println("What will your new password be?");
					e1.setPassword(stdin.next() );
					System.out.println("Your password is now '" + e1.getPassword() + "'.");
					break;
				
				case 3:
					System.out.println("How large is your mailbox? (in terms of MB)");
					
					if(stdin.nextInt() > 0) {
						e1.setMailbox(stdin.nextInt() );
						System.out.println("Your mailbox capacity is now " + e1.getMailbox() + ".");
					}
					else
						System.out.println("That is not a valid input. Try again later.");
					break;
					
				case 4: 
					System.out.println("What is your new email? ");
					e1.setEmail(stdin.next());
					System.out.println("Your new email is now " + e1.getEmail() + ".");
					break;
				
				case 5:
					System.out.println("EMPLOYEE RECORDS: ");
					System.out.println("Name: " + e1.getFirstName() + " " + e1.getLastName() );
					System.out.println("EMAIL: " + e1.getEmail() );
					System.out.println("PASSWORD: " + e1.getPassword() );
					System.out.println("MAILBOX CAPACITY: " + e1.getMailbox() );
					break;
					
				case -1:
					System.out.println("Thank you. Have a nice day.");
					System.exit(0);
					
				default:
					System.out.println("That command was not one of the options, try again.");
			}
			
		}while(!(change == -1));
			
		stdin.close();
	}

}
