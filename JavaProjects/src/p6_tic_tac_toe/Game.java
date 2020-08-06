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
		String name1 = input.nextLine();
		System.out.println("Enter Player 2's name:");
		String name2 = input.nextLine();
		
		Player p1 = new Player(name1, "x");
		Player p2 = new Player(name2, "o");
		
		Board b = new Board();
		b.display();
		
		//players alternate turns until someone wins
		boolean finished = false;
		while(finished == false) {
			//Player 1's turn
			System.out.println("Enter the row and column you want to play");
			int row1 = input.nextInt();
			int col1 = input.nextInt();
			b.turn(p1, row1, col1);
			
			if( b.winner(p1) ) {
				
			}
			
			//Player 2's turn
			System.out.println("Enter the row and column you want to play");
			int row2 = input.nextInt();
			int col2 = input.nextInt();
			b.turn(p2, row2, col2);
			
			b.winner(p2);
			
			//need something for a draw
		}
		
		
		
		input.close();
	}
	
	
	
}
