package p1_simple_banking_application;

import java.util.Scanner;

public class Test{

	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		int cont = 0;
		
		do {
			System.out.println("Hello, are you interested in joining our bank? ");
			String answer = stdin.nextLine();
			cont = Person.stay(answer); //will exit if answer is no, keep asking until ans = yes
		}while(cont == 0);
		
		System.out.println("Awesome! What is your name?");
		String name = stdin.nextLine();
		
		System.out.println("Nice to meet you, " + name + ". What is your new balance?");
		double bal = stdin.nextDouble();
		
		Person p = new Person(name, bal);
		boolean exit = false;
		boolean d_s; //deposit successful
		boolean w_s;  //withdrawl successful
		int task;
		double amount;
		
		do {
			System.out.println("What would you like to do " + name + "?");
			System.out.println("1 to deposit, 2 to withdraw, 3 to check balance, 0 to leave.");
			task = stdin.nextInt();
			
			if(task == 1) {
				System.out.println("How much would you like to deposit?");
				amount = stdin.nextDouble();
				
				d_s = p.deposit(amount );
				
				if(d_s)
					System.out.println("Your balance is now $" + p.getBalance() );
			}
			else if(task == 2) {
				System.out.println("How much would you like to withdraw?");
				w_s = p.withdraw(stdin.nextDouble());
				
				if(w_s)
					System.out.println("Your balance is now $" + p.getBalance());
				
			}
			else if(task == 3)
				System.out.println("Your balance is $" + p.getBalance() );
			
			else if(task == 0) {
				System.out.println("Have a nice day");
				System.exit(0);
			}
				
			else
				System.out.println("Read the following again: ");
			
		}while(exit == false);
		
		
		

		
		stdin.close();
	}

}
