package p5_text_based_adventure_game;

import java.util.Scanner;
public class Game {

	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		System.out.println("=====================================================");
		System.out.println("WARNING: If you enter the dungeon, monsters will attack. If you want to continue"
				+ " input your name, or enter q to quit.");
		String input = stdin.nextLine();
		if(input.equals("q") ) {
			System.out.println("Goodbye.");
			System.exit(0);
		}
		
		Hero h = new Hero(input);
		
		boolean exit = false;
		String move;
		
		while(exit == false) {
			//encounter an enemy
			Enemy e = new Enemy();
			System.out.println("=====================================================");
			System.out.println("\tWatch out " + h.getName() + "! There is a " + e.getType() + " ahead!\n");
			
			boolean battleOver = false;
			while(battleOver == false) {
				//show player and enemy's HP
				System.out.println(h.getName()+ ": " + h.getHP() + " HP");
				System.out.println(e.getType() + ": " + e.getHP() + " HP\n");
				
				//hero chooses an option
				System.out.println("What will you do?");
				System.out.println("\t1 -> Attack!");
				System.out.println("\t2 -> Drink a Health Potion! (" + h.getPotions() + " potions left)");
				System.out.println("\t3 -> Run Away!");
				
				//option is done
				//either run away or enemy is attacked or hero heals from potions
				move = stdin.nextLine();
				if(move.equals("1") ) {
					//player attacks
					h.attack(e);
					
					if(e.getHP() <= 0) {
						break;
					}
					
					//if no run, enemy attacks back
					e.attack(h);
						
				}
				
				else if(move.equals("2") ) {
					//player heals from a potion
					h.usePotion();
					
					//if no run, enemy attacks back
					e.attack(h);
				}
				
				else if(move.equals("3") ) {
					boolean success;
					//player runs
					success = h.runAway();
					
					if(success) {
						System.out.println("You successfully escaped!");
						break;
					}
					else {
						System.out.println("You failed to escape!");
					}
						
				}
				
				else {
					System.out.println("That is not a valid input, try again.");
				}
					
				//repeat until one dies
			}//battle loop
				
			//continue through the dungeon
			System.out.println("Would you like to continue? Enter any key to continue or q to quit.");
			input = stdin.nextLine();
			if(input.equals("q") ) {
				System.out.println("Bye " + h.getName() + "! I hope you had fun!");
				System.exit(0);
			}
			
		}//inside the dungeon loop
		
		
		
		stdin.close();
	}//main

}
