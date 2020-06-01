package p0_connect_four;

import java.util.Scanner;

public class Connect4Game extends Board{

	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		
		Board c = new Board();
		
		char[][] board = new char[7][15];
		
		
		c.defaultBoard(board);
		
		int colR;
		int colY;
		boolean exit = false;
		int validInput;
		
		c.displayBoard(board);
		
		while(exit == false) {
			do { 
				System.out.println("Drop a red disk at column (0 - 6): ");
				colR = stdin.nextInt();
				validInput = c.updateBoard(board, colR, 'R');
				c.displayBoard(board);
				if(c.horizontal(board, 'R') == 1 || c.vertical(board, 'R') == 1 || c.diagonal2(board, 'R', colR) == 1) {
					c.gameOver('R');
					
				}
			}while(validInput == -1); //repeat process if the input is invalid
			
			do { 
				System.out.println("Drop a yellow disk at column (0 - 6): ");
				colY = stdin.nextInt();
				validInput = c.updateBoard(board, colY, 'Y');
				c.displayBoard(board);
				if(c.horizontal(board, 'Y') == 1 || c.vertical(board, 'Y') == 1 || c.diagonal2(board, 'Y', colY) == 1) {
					c.gameOver('Y');
					
				}
			}while(validInput == -1);
			
		}
		
		
		stdin.close();
	}
	

}

