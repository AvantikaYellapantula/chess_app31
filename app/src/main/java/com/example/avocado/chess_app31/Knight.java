/**
 * @authors
 * Rahil Chertara
 * Avantika Yellapantula
 */
package com.example.avocado.chess_app31;



public class Knight extends Piece{
	
public String type = "N";



	
	public Knight(boolean color) {
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
		
		if(specialCase.isCapturing) {
	    if( ( (start.m_file-2==end.m_file)||(start.m_file+2==end.m_file) )&&(  (start.m_rank-1==end.m_rank)|| (start.m_rank+1==end.m_rank) )  ) {
				  return true;
			}
		else if( ( (start.m_rank+2==end.m_rank)||(start.m_rank-2==end.m_rank) )&&( (start.m_file-1==end.m_file)|| (start.m_file+1==end.m_file) ) ) {
			    return true;
		}
		else {
			//System.out.println("knight cant capture like that");
			return false;
		}
		}
		

		
		if( ( (start.m_file-2==end.m_file)|| (start.m_file+2==end.m_file))&&( (start.m_rank-1==end.m_rank)|| (start.m_rank+1==end.m_rank) ) ) {
		  return true;
	    }
        else if( ( (start.m_rank+2==end.m_rank)||(start.m_rank-2==end.m_rank) )&&(  (start.m_file-1==end.m_file)||(start.m_file+1==end.m_file) ) ) {
	    return true;
        }
        else {
        	return false;
        }
		
	
	
	}
	

}