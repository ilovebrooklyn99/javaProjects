package p6_tic_tac_toe;
import java.util.Scanner;

public class Game {

	//create and display tic tac toe board
	//needs two players, one 'x' and one 'o'
	//each player moves one after the other until three in a row or all spaces are filled
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Welcome to Tristan's tic-tac-toe mingame!");
		System.out.println("Enter Player 1's name:");
		String p1 = input.nextLine();
		System.out.println("Enter Player 2's name:");
		String p2 = input.nextLine();
		
		Board b = new Board();
		b.display();
		
		
		
		
		
		input.close();
	}
	
	
	
}
