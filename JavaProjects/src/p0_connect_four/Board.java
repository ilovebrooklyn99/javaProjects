package p0_connect_four;

public class Board {

	private int rows = 7;
	private int cols = 15;
	
	public Board() {
		//no-arg constructor
	}
	
	public Board(int rows, int cols) {
		this.rows = rows;
		this.cols = cols;
	}
	
	public void defaultBoard(char[][] board) {
	/*	System.out.println( "| | | | | | |");
		System.out.println( "| | | | | | |");
		System.out.println( "| | | | | | |");
		System.out.println( "| | | | | | |");
		System.out.println( "| | | | | | |");
		System.out.println( "| | | | | | |");
		System.out.println( "-------------");*/
		
		for(int i = 0; i < this.rows; i++) {
			for(int j = 0; j < this.cols; j++) {
				if(i == this.rows - 1)
					board[i][j] = '-';   //bottom is all dashes
				else {
					if(j % 2 == 0)
						board[i][j] = '|';
					else
						board[i][j] = ' ';
				}
			}
		}//first for loop
		
	}//default board
	
	public void displayBoard(char[][] board) {
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[i].length; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}
	
	public int updateBoard(char[][] board, int inputCol, char letter) {
		int realCol = inputCol * 2 + 1;
		
		if(inputCol >= board.length) {
			System.out.println("This column is an invalid column, try another one.");
			return -1;
		}
		
		if(board[0][realCol] == 'R' || board[0][realCol] == 'Y') {
			System.out.println("This column is full, try another one.");
			return -1;
		}
		
		for(int i = board.length - 2; i >= 0; i--) {
			if(board[i][realCol] == 'R' || board[i][realCol] == 'Y') {
				continue;
			}
			else {
				board[i][realCol] = letter;
				break;
			}
			
				
		}//for loop
		
		return 1;
		
	}//update board
	
	
	public int horizontal(char[][] board, char letter) {
		int col;
		
		for(int i = board.length - 2; i >= 0; i--) {		//start from index 5
			for(int j = 0; j < 6; j++) {  //highest col is 13, when j is 6
				col = j * 2 + 1;
				if(board[i][col] == letter) {
					
					for(int k = 0; k < 4; k++) {
						col = k * 2 + 1;
						if(board[i][col] == letter && board[i][col + 2] == letter &&
								board[i][col + 4] == letter && board[i][col + 6] == letter)
							return 1;
					}
					
				}//first if
				
			}
		}//first for 
		
		return -1;
	}		//checks the whole board
	
	public int vertical(char[][] board, char letter) {
		int col;
		
		for(int i = board.length - 2; i >= 0; i--) {
			for(int j = 0; j < board[i].length/2; j++) {
				col = j * 2 + 1;
				if(board[i][col] == letter) {
					
					for(int k = 0; k < 3; k++) {
						if(board[k][col] == letter && board[k+1][col] == letter &&
								board[k+2][col] == letter && board[k+3][col] == letter)
							return 1;
					}
					
				}//first if
				
			}
		}//first for 
		
		return -1;
	}	//checks the whole board
	
	public int diagonal2(char[][] board, char letter, int col) {
		
		for(int x = 0; x < board.length; x++) {
			for(int y = 0; y < board[x].length; y++) {
				if(board[x][y] == letter) {
					
					if ((x + 3) < board.length && (y+6) < board[x].length)  {
						if(board[x+1][y+2] == letter && board[x+2][y+4] == letter && board[x+3][y+6] == letter)
							return 1;
					}
					
					if ((x + 3) < board.length && (y-6) >= 0)  {
						if(board[x+1][y-2] == letter && board[x+2][y-4] == letter && board[x+3][y-6] == letter)
							return 1;
					}
				
					if ((x - 3) >= 0 && (y+6) < board[x].length)  {
						if(board[x-1][y+2] == letter && board[x-2][y+4] == letter && board[x-3][y+6] == letter)
							return 1;
					}
		
					if ((x - 3) >= 0 && (y-6) >= 0)  {
						if(board[x-1][y-2] == letter && board[x-2][y-4] == letter && board[x-3][y-6] == letter)
							return 1;
					}
					
				}//first if
			}//second for loop
		}//first for loop
		
		return -1;
	}	//checks whole board
	
	
	public void gameOver(char letter) {
		if(letter == 'Y') {
			System.out.println("Yellow team won!");
			System.exit(0);
		}
		else if(letter == 'R') {
			System.out.println("Red team won!");
			System.exit(0);
		}
			 
	}
	
}//class
