/**
 * @authors
 * Rahil Chertara
 * Avantika Yellapantula
 */


package com.example.avocado.chess_app31;



public class controllerView {

	
	public Board board;
	Board copyBoard;
	public boolean isGameOver;
	public boolean whiteResigned;
	public boolean blackResigned;
	
	
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
		if(start!=null && end!=null&&promotion!=null) {
			if(promotion.equals("AI")) {
				isValidMove=copyBoard.boardMove(start, end, null);
			}
		}





		return isValidMove;


	}


	public boolean aiMove() {

		boolean isValidMove=false;
		String promo=null;
		//PairCoordinate start=new PairCoordinate(file,rank);





		//PairCoordinate end= new PairCoordinate(fileEnd,rankEnd);
		char[] letters= {'a','b','c','d','e','f','g','h'};
		char[] nums= {'1','2','3','4','5','6','7','8'};

		for(int i=0;i<8;i++) {
			if(isValidMove==true) {
				break;
			}
			for(int j=0;j<8;j++) {
				if(isValidMove==true) {
					break;
				}
				for(int k=0;k<8;k++){
					if(isValidMove==true) {
						break;
					}
					for(int m=0;m<8;m++) {

						copyBoard=this.board.copyBoard();
						isValidMove= doMove(letters[i], nums[j], letters[k], nums[m], "AI");


						if(isValidMove==true) {
							board=copyBoard;//hmmm //otherwise chnage board to this shit
							break;
						}


					}
				}
			}
		}




		return true;


	}
	
	/**
	 * this method gets the board
	 *
	 * @param
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
	 * @param
	 * @return type board/whose turn it is to play
	 */
	public boolean isWhiteTurn() {
		return board.whiteTurn;
	}

	
	
	
	
	
	
}
