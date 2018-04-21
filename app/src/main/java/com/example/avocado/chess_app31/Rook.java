/**
 * @authors
 * Rahil Chertara
 * Avantika Yellapantula
 */
package model;

import utility.PairCoordinate;



public class Rook extends Piece{

	
	
	
public String type = "R";

boolean isFirstMove=true;
	
	public Rook(boolean color) {
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
		
	 if(specialCase.pieceInPath==false) {
		 
   if ( (start.distanceFormula(end) <=7 && start.isSameFile(end)) || ( (start.distanceFormula(end)<=7) && start.isSameRank(end)) ) {//unless king can switch with rook
      isFirstMove=false;
	   return true;
	     } 
		
		else {
	//		System.out.println("cant do this move rook");
			return false;
		}
	}
	
	 else {
		 return false;
	 }
	
	
	
	
	}

}
