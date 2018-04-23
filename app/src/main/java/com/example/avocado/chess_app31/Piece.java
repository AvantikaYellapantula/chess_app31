/**
 * @authors
 * Rahil Chertara
 * Avantika Yellapantula
 */
package com.example.avocado.chess_app31;


import java.io.Serializable;

public abstract class Piece implements Serializable{

	private static final long serialVersionUID = 3569870795027701054L;
	/*
    /*
     * This decides how exactly the pieces can move
     *
     * First of all, there are two main players, White and black.
     * So no matter which piece is moving, there needs to be a player_color
     *  --> That can be a boolean value
     *  A piece can only move to a spot given two options:
     *  --> if that spot is empty
     *  --> kill shot
     *  Both can be represented by boolean values
     * */
	public boolean color;
	public String type;
	
	
	public Piece(boolean color) {
		this.color=color;
	}

	
	/**
	 * This decides which color the piece is
	 *
	 * @param Piece p
	 * @return boolean false=black/true=white
	 */
public boolean isWhite(Piece p) { //white is true black is false
		if(p.color==true) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/*
	 * How do we decide if a player can  move or not
	 * - we need the old coordinates
	 * - we need the new coordinates
	 * - boolean can move
	 * */


/**
 * This method gives the 'ok' to make the move in terms of distance. It uses the distance formula to check whether the bishop can move in the user-desired direction. 
 *
 * @param PairCoordinate start, PairCoordinate end,allCases specialCase
 * @return boolean false/true, whether it's 'ok' to move
 */
public boolean isOkMove(PairCoordinate start, PairCoordinate end, allCases specialCase) {//MAY HAVE TO COME BACK TO THIS LATER!
	
    if ( start.distanceFormula(end) <= 7) {
		return true;
	} 
	
	else {
		//System.out.print("Distance too big cant do this move");
		return false;
	}
}


   public String toString() {
	   String ans;
	   
	   if(this.color==true) {
		   ans="w";
		   return ans;
	   }
	   else {
		   ans="b";
		   return ans;
	   }
	   
   }

	//public abstract boolean movePiece(int oX, int oY, int nX, int nY, boolean canMove);

	//we need another abstract class to write the name of the piece on the console that can be used for each one of the pieces
	//public abstract String writeName();
	
	
}
