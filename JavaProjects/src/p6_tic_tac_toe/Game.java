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
		boolean finished1 = false;
		boolean finished2 = false;
		
		while(finished == false) {
			
			//Player 1's turn
			while(finished1 == false) {
				System.out.println("Enter the row.");
				int row1 = input.nextInt();
				System.out.println("Enter the column.");
				int col1 = input.nextInt();
				finished1 = b.validTurn(p1, row1, col1);
			}
			
			if( b.winner(p1) ) {
				System.out.println("Congratulations " + p1.getName() + "! Press any key to continue or 3 to exit.");
				if(input.next().equals("3")) {
					System.exit(0);
				}
				else {
					b.display();
				}
			}
			System.out.println(b.getTurns());
			if(b.getTurns() == 9) {
				System.out.println("A draw! Press any key to continue or 3 to exit.");
				if(input.next().equals("3")) {
					System.exit(0);
				}
				else {
					b.clearBoard(b.getBoard());
					b.display();
				}
			}
				
			
			//Player 2's turn
			while(finished2 == false) {
				System.out.println("Enter the row.");
				int row2 = input.nextInt();
				System.out.println("Enter the column.");
				int col2 = input.nextInt();
				finished2 = b.validTurn(p2, row2, col2);
			}//while
			if( b.winner(p2) ) {
				System.out.println("Congratulations " + p2.getName() + "! Press any key to continue or 3 to exit.");
				if(input.nextLine().equals("3")) {
					System.exit(0);
				}
				else {
					b.clearBoard(b.getBoard());
					b.display();
				}
			}
			
			System.out.println(b.getTurns());
			if(b.getTurns() >= 9) {
				if(input.next().equals("3")) {
					System.exit(0);
				}
			}
			
			
			finished1 = false;
			finished2 = false;
		}//while
		
		
		input.close();
	}
	
	
	
}
