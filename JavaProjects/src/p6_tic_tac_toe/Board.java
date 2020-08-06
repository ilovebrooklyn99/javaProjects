package p6_tic_tac_toe;

public class Board {
	private String[][] board;
	
	public Board() {
		board = new String[3][3];
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[i].length; j++) {
				board[i][j] = "?";
			}
		}
	}
	
	public void clearBoard(String[][] b) {
		for(int i = 0; i < b.length; i++) {
			for(int j = 0; j < b[i].length; j++) {
				b[i][j] = "?";
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
	public void turn(Player p, int row, int col) {
		if(row > 2 || col > 2) {
			System.out.println("You may choose rows or cols between 0 and 2.");
		}
		else if(this.board[row][col].equals("x") || this.board[row][col].equals("o")) {
			System.out.println("That space is already filled. Try again.");
		}
		else {
			board[row][col] = p.getPiece();
		}
			
		display();
	}
	
	//check if someone won
	public boolean winner(Player p) {
		String s = p.getPiece();
		
		//diagonal wins
		if( board[0][0].equals(s) && board[1][1].equals(s) && board[2][2].equals(s) || 
				board[0][2].equals(s) && board[1][1].equals(s) && board[2][0].equals(s) ) {
			System.out.println("Congrats " + p.getName());
			clearBoard(this.board);
			return true;
		}
				
		//vertical and horizontal wins
		for(int i = 0; i < board.length; i++) {
			if(board[i][0].equals(s) && board[i][1].equals(s) && board[i][2].equals(s) || 
					board[0][i].equals(s) && board[1][i].equals(s) && board[2][i].equals(s)
					) {
				System.out.println("Congrats " + p.getName());
				clearBoard(this.board);
				return true; 
			}
		}
		
		
		return false;
	}
	
	
	
}
