/**
 * @authors
 * Rahil Chertara
 * Avantika Yellapantula
 */
package model;


import utility.PairCoordinate;
import utility.*;


public class Tile {
	//using vector type of system that requires coordinate and piece
	
	public PairCoordinate coordinate;
	public Piece piece;
	
	//constructor
	public Tile(PairCoordinate coordinate, Piece piece) {
			this.coordinate=coordinate; this.piece=piece;
	}
	public boolean isEmpty() {
		return this.piece==null;
	}
	
	
	
	/**
	 * Overrides the toString Method
	 *
	 * @param none
	 * @return String color+type
	 */
		//is the tile a white tile or a black tile?
	public String toString() {
		if(this.piece==null) {
			//both x and y are even OR both x and y are odd
			//then the tile should be white
	if((this.coordinate.m_file % 2 == 0 && this.coordinate.m_rank % 2 == 0) || (this.coordinate.m_file % 2 != 0 && this.coordinate.m_rank % 2 != 0) ) {
				return "  ";
			}else {
				return "##";
			}
		}else {
			return piece.toString();
		}
	}//end toString method
	

	//is the tile free?
	
	

}
