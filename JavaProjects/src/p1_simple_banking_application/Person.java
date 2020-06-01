package p1_simple_banking_application;

public class Person {

	private String name;
	private double balance;
	public static boolean w;
	
	public Person(String name) {
		this.name = name;
		this.balance = 0;
	}
	
	public Person(String name, double balance) {
		this.name = name;
		this.balance = balance;
	}
	
	public String getName() {
		return this.name;
	}
	
	public double getBalance() {
		return this.balance;
	}
	
	public boolean deposit(double num) {
		if (!(num > 0)) {
			System.out.println("You cannot deposit this amount. Try again");
			return false;
		}
		else {
			this.balance = this.balance + num;
			return true;
		}
	}
	
	public boolean withdraw(double num) {
		if(this.balance - num < 0) {
			System.out.println("This amount is too high! You do not have sufficient funds.");
			return false;
		}
		else {
			this.balance = this.balance - num;
			return true;
		}
	}
	
	
	public static int stay(String ans) {
		if(ans.equals("no") || ans.equals("No") ) {
			System.out.println("Have a nice day.");
			System.exit(0);
		}
		
		else if(!(ans.equals("yes") || ans.equals("Yes") ) ) {
			System.out.println("Please type yes or no.");
			return 0;
		}
		
		else {
			return 1;
		}
		
		return 0;
	}
	
	public double createBalance() {
		return (int)(Math.random() * 1000) ;
	}
}
