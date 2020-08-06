package p6_tic_tac_toe;

public class Board {
	String[][] board;
	
	public Board() {
		board = new String[3][3];
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[i].length; j++) {
				board[i][j] = "?";
			}
		}
	}
	
	//display method
	public void display() {
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[i].length; j++) {
				System.out.print(" " + board[i][j]);
				if(j != board.length-1)
					System.out.print(" | ");
			}
			System.out.println();
			if(i != board.length-1)
				System.out.println("------------");
		}
	
	}
	
	//action method
	public void turn(int row, int col) {
		if(this.board[row][col].equals("x") || this.board[row][col].equals("o")) {
			System.out.println("That space is already filled. Try again.");
		}
			
	}
	
	
}
