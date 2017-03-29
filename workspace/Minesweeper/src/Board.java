import java.util.Random;

public class Board {
	//int 0 will be a blank cell
	//1 to 8 will display as numbers
	//9 will be a bomb
	//10 will be a flag
	//11 will be a question mark
	private class Cell{
		//instance variables for Cell
		private int contents;
		private boolean uncovered;
		
		private Cell(){
			this.contents = 0;
			this.uncovered = false;
		}
		
		private void uncover(){
			this.uncovered = true;
		}
		
		private void setContents(int contents){
			this.contents = contents;
		}
		
		private void incrementContents(){
			this.contents += 1;
		}
		
		private int getContents(){
			return contents;
		}
	}
	
	//instance variables for Board
	private Cell[][] board = null;
	
	//singleton??
	public Board(int length, int width){
		//todo change boundaries for bigger boards
		//todo choose number of bombs
		board = new Cell[9][9];
		//board = new Cell[length][width];
		this.resetBoard(length, width);
	}
	
//	public getInstance(){
//		if(board == null){
//			board = 
//		}
//	}
	
	public void resetBoard(int length, int width){
		//create an empty board
		for(int i = 0; i < length; i++){
			for(int j = 0; j < width; j++){
				board[i][j] = new Cell();
			}
		}
		//add bombs
		//todo change boundaries for bigger boards	
			addMines();	
	}
	
	private void addMines(){
		boolean alreadyAdded = false;
		Random r = new Random();
		int counter = 0;
		int x = 0;
		int y = 0;
		while(counter != 10){
			x = r.nextInt(9);
			y = r.nextInt(9);
			//very shitty way of doing it
			if(board[x][y].getContents() != 9){
				board[x][y].setContents(9);
				counter += 1;
				for(int a = -1; a < 2; a++){
					for(int b = -1; b < 2; b++){
						int tempx = x + a;
						int tempy = y + b;
						if(a != 0 || b != 0){ //check if it is itself
							if((tempx > -1 && tempx < 9) && (tempy > -1 && tempy < 9)){ //check if it is out of bounds
								if(board[tempx][tempy].getContents() < 9){ //check if it is a bomb
									board[tempx][tempy].incrementContents();
								}
							}
						}
					}
				}
			}
		}
	}
	
//	private void populateBoard(){
//		for(int i = 1; i < 8; i++){
//			for(int a = -1; a < 2; a++){
//				for(int b = -1; b < 2; b++){
//					if()
//				}
//			}
//		}
//	}
	
	public void display(){
		for(int i = 0; i < 9; i++){
			for(int j = 0; j < 9; j++){
				if(board[i][j].getContents() == 9){
					System.out.print('*');
					System.out.print(" ");
				}else{
					System.out.print(board[j][i].getContents());
					System.out.print(" ");
				}
			}
		System.out.println();
		}
	}
	
}
