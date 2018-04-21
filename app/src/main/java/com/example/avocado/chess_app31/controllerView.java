/**
 * @authors
 * Rahil Chertara
 * Avantika Yellapantula
 */


package controller;

import model.Board;
import utility.PairCoordinate;

public class controllerView {

	
	public Board board;
	
	public boolean isGameOver;
	
	
	public controllerView() {
		this.board= new Board();
		this.isGameOver=false;
	}


	/*public void isDraw() {
		 isGameOver=true; //not used 
		 
	}
	
	public void Resign() {
	    isGameOver=true;//not used
	    
	    
	}
	*/
	
	/**
	 * This method gives the 'ok' to make the move. It checks whether the coordinates are within bounds, and uses PairCoordinate to check the movements of the piece.
	 *
	 * @param char file, char rank, char fileEnd, char rankEnd, String promotion
	 * @return String boolean whether the move is valid or not
	 */
	public boolean doMove(char file, char rank, char fileEnd, char rankEnd, String promotion) {
		boolean isValidMove=false;
	
			PairCoordinate start=new PairCoordinate(file,rank);
			
			PairCoordinate end= new PairCoordinate(fileEnd,rankEnd);
			/*
			 CHECK TO SEE IF THESE COORDINATES ARE WITHIN BOUND!!!!
			 */
			if(start.m_file<0||start.m_file>7||start.m_rank<0||start.m_rank>7||
			   end.m_file<0||end.m_file>7||end.m_rank<0||end.m_rank>7){
			
			//	System.out.println("Invalid Coordinate out of bounds");
				return false;
				//Maybe throw some exception 
	
				
			}

			
			if(start!=null && end!=null ) {
 				isValidMove=board.boardMove(start, end, promotion);
			}
			
			
			
			
			
		return isValidMove;
			
		
	}
	
	/**
	 * this method gets the board
	 *
	 * @param none
	 * @return string/toString
	 */
	
	public String getBoard() {
	
		String str= this.board.toString();
		if(str==null) {
			System.out.print("no board");
		}
		return str;
	}

	/**
	 * this method tells whose turn it is to play
	 *
	 * @param none
	 * @return type board/whose turn it is to play
	 */
	public boolean isWhiteTurn() {
		return board.whiteTurn;
	}

	
	
	
	
	
	
}
