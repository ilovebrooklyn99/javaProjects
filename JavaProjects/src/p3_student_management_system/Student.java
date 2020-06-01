package p3_student_management_system;

import java.util.Scanner;

public class Student {
	Scanner stdin = new Scanner(System.in);
	private String firstName;
	private String lastName;
	private int year;
	private int[] id = new int[5];
	private double balance = Math.round(1800 * 100.0) / 100.0;
	private double tuition;
	private boolean[] courses = new boolean[5];
	String temp;
	
	public Student() {
		System.out.println("What is the first name of this student?");
		this.firstName = stdin.next();
		
		System.out.println("What is the last name of this student?");
		this.lastName = stdin.next();
		
		System.out.println("What year is " + this.firstName + "?");
		System.out.println("1 for Freshman.");
		System.out.println("2 for Sophomore.");
		System.out.println("3 for Junior.");
		System.out.println("4 for Senior.");
		
		boolean exit = false;
		do {
			if(!stdin.hasNextInt() ) {
				stdin.nextLine();
				System.out.println("This is not a valid input, read the class codes again.");
				stdin.nextLine();		//not sure of why i need a second one
			}
			else {
				this.year = stdin.nextInt();
				if(this.year < 1 || this.year > 4 ) {
					System.out.println("This is not a valid class code, try again.");
					stdin.nextLine();
				}
				else {
					exit = true;
				}
			}
		}while(exit == false);
		
		createID(this.year);
		
		System.out.print("Name: " + firstName + " " + lastName + ", Student ID: ");
		for(int i = 0; i < 5; i++) {
			System.out.print(id[i]);
		}
		System.out.println();
		
		System.out.println("Balance: " + this.balance);
	}
	
	public void payTuition() {
		int count = 0;
		double payment;
		for(int i = 0; i < 5; i++) {
			if(courses[i])
				count++;
		}
		
		tuition = Math.round(600 * count * 100.0) / 100.0;
		
		System.out.println("Your balance is $" + this.balance + " and you owe $" + tuition + ".");
		System.out.println("How much do you want to pay?");
		payment = stdin.nextDouble();
		
		this.balance = this.balance - payment;
		tuition = tuition - payment;
		
		System.out.println("You still owe $" + Math.round(tuition) );
		System.out.println("Your balance is "+ Math.round(this.balance) );
		
		System.out.println("=========================================================================================");
	}
	
	public void enroll() {
		String input = "hi";
		int course;
		do {
			System.out.println("Enter a class code to enroll in a course. Press q to quit.");
			System.out.println("0 - History 101\n1 - Math 101\n2 - English 101\n3 - Chemistry 101\n4 - Computer Science 101");
			
			if(!stdin.hasNextInt() ) {
				stdin.nextLine();
				input = stdin.nextLine();
			}
			else {
				course = stdin.nextInt();
				
				if(course < 0 || course > 5 ) {
					System.out.println("This is not a valid class code, try again.");
				}
				else {
					if(courses[course] == true) {
						System.out.println("You are already enrolled in that course. Try another." );
					}
					else {
						courses[course] = true;
					}
				}
			}
			System.out.println("=========================================================================================");
			System.out.println("You are currently enrolled in: ");
			courseList();
			System.out.println("=========================================================================================");
			
		}while(!input.equals("q"));
		
		
		
	}//enroll
	
	public void courseList() {
		if(courses[0])
			System.out.println("History 101");
		if(courses[1])
			System.out.println("Mathematics 101");
		if(courses[2])
			System.out.println("English 101");
		if(courses[3])
			System.out.println("Chemistry 101");
		if(courses[4])
			System.out.println("Computer Science 101");
	}
	
	public void printOut() {
		System.out.print("Name: " + firstName + " " + lastName);
		System.out.println("Grade level: " + this.year + "Student ID: ");
		for(int i = 0; i < 5; i++) {
			System.out.print(id[i]);
		}
		System.out.println();
		
		System.out.println("Balance: " + this.balance);
		courseList();
		
		System.out.println("=========================================================================================");
	}
	
	public void createID(int year) {
		this.id[0] = year;
		
		for(int i = 1; i < 5; i++) {
			this.id[i] = (int)(Math.random() * 10);
		}
	}
	
	public int getYear() {
		return this.year;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	
}
