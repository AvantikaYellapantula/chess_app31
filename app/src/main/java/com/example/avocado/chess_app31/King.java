/**
 * @authors
 * Rahil Chertara
 * Avantika Yellapantula
 */
package com.example.avocado.chess_app31;





public class King extends Piece{
	
public String type = "K";

public boolean isFirstMove=true;
	
	public King(boolean color) {
		super(color);
		
	}
	
	/**
	 * Overrides the toString Method
	 *
	 * @param none
	 * @return String color+type
	 */
	public String toString() {
		if(this.color==true) {
			return "w"+type;
		}
		else {
			return "b"+type;
		}
	}
	
	/**
	 * This method gives the 'ok' to make the move in terms of distance. It uses the distance formula to check whether the bishop can move in the user-desired direction. 
	 *
	 * @param PairCoordinate start, PairCoordinate end,allCases specialCase
	 * @return boolean false/true, whether it's 'ok' to move
	 */
	public boolean isOkMove(PairCoordinate start, PairCoordinate end,allCases specialCase) { //MAY HAVE TO COME BACK TO THIS LATER!
	
	if(specialCase.pieceInPath==false) { //checks if anything is in its path from start to end  
		
		
		
	if(color==true&&(start.m_file==4&&start.m_rank==7)) {//white king castle has not moved
		if(start.distanceFormula(end)==2 && (start.m_rank==7 && end.m_rank==7)&&this.isFirstMove==true ) {
			specialCase.Castling=true;
			return true;
		}
	}
	if(color==false&&(start.m_file==4&&start.m_rank==0) ) {//white king castle has not moved
		if(start.distanceFormula(end)==2  && (start.m_rank==0 && end.m_rank==0)&&this.isFirstMove==true ) {
			specialCase.Castling=true;
			return true;
		}
	}
		
	if ( start.distanceFormula(end) == 1 && start.isTouching(end)) {
		    isFirstMove=false;
			return true;
	     } 
		
	
	}
	
	
		return false;
	
	
	

}
	
}
