/**
 * @authors
 * Rahil Chertara
 * Avantika Yellapantula
 */
package com.example.avocado.chess_app31;

public class PairCoordinate {

	public int m_file;
	public int m_rank;
	
	
	public PairCoordinate(int i, int j) { //used for board intialization in beginning
		this.m_file=i; //col
		this.m_rank=j; //rank
	}

	
	public PairCoordinate(char file,char rank) {//used for inputs 
		
		String c=(file+"").toLowerCase();//convert the file into an int
		
		int tempFile=c.charAt(0)-'a';
		
		int tempRank=Math.abs(Integer.parseInt(rank+"")-8);
		
		
		//take string representation of int and make it an int
		
	//	System.out.println("Converted cord "+tempRank+","+tempFile);
	
		if(tempFile>7 || tempFile<0) {
		//	System.out.println("Your file is out of bounds");
			
			//must ask again for correct input
			if(tempRank>7||tempRank<0) {
		//		System.out.println("Your rank is out of bounds");
			}
		}
		
		
		
		else {
			this.m_file=tempFile;
			this.m_rank=tempRank;
		}
		//System.out.println("Converted cord "+tempRank+","+tempFile);
		
	}
	
	
	/**
	 * checks whether the files for each piece are the same
	 *
	 * @param PairCoordinate coord
	 * @return boolean false/true
	 */
	public boolean isSameFile(PairCoordinate cord) {
		if(this.m_file==cord.m_file) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	/**
	 * checks whether the ranks for each piece are the same
	 *
	 * @param PairCoordinate coord
	 * @return boolean false/true
	 */
	public boolean isSameRank(PairCoordinate cord) {
		if(this.m_rank==cord.m_rank) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Overrides the equals method
	 *
	 * @param Object op
	 * @return boolean false/true
	 */
	public boolean equals(Object op) {
		if ((op instanceof PairCoordinate)==false) {
			return false;
		} 
		
		else {
		
			PairCoordinate cord= ((PairCoordinate) op);

			if (this.isSameFile(cord) && this.isSameRank(cord)) {
					return true;
			} 
			else {
					return false;
			}
		}
	}
	
	/**
	 * Overrides the toString Method
	 *
	 * @param none
	 * @return int distance
	 */
	public String toString() { //reconvert back to string for printing on board 
		return this.getCharFile(this.m_file) + "" + this.getCharRank(this.m_rank);
	}
	
	public int distanceFormula(PairCoordinate B) {//will be helpful in seeing no piece moves off board
		//AB= sqrt((x2−x1)2+(y2−y1)2)
		int distance;
		
		 double temp=Math.pow(B.m_file-this.m_file,2)+ Math.pow(B.m_rank-this.m_rank,2);
		 temp=Math.sqrt(temp);
		 distance=(int)temp;
		
		return distance;
		
	}
	
	
	/**
	 * checks whether the pieces are right next to each other, that is, the next tile over
	 *
	 * @param PairCoordinate coord
	 * @return boolean false/true
	 */
	public boolean isTouching(PairCoordinate cord) {
		//horizontal touch check
		if((this.m_file==cord.m_file+1||this.m_file==cord.m_file-1) &&this.m_rank==cord.m_rank) {
			return true;
		}
		//vertical touch check
		else if((this.m_rank==cord.m_rank+1||this.m_rank==cord.m_rank-1)&&this.m_file==cord.m_file) {
			return true;
		}
		//diagonal touch check 
		else {
			if(this.m_rank==cord.m_rank+1) {//this is above the cord  
				if(this.m_file==cord.m_file+1||this.m_file==cord.m_file-1) {//do left down diag and right down diag
					return true;
				}
			}
			
			if(this.m_rank==cord.m_rank-1) {// this is below the cord
				if(this.m_file==cord.m_file+1||this.m_file==cord.m_file-1) {//do left up diag and right up diag check
					return true;
				}
			}
		}
		
		return false;
	}
	
	
	/**
	 * checks whether the pieces are diagonally across from each other, that is, the next tile over diagonally
	 *
	 * @param PairCoordinate coord2
	 * @return boolean false/true
	 */
	public boolean hasDiagPath(PairCoordinate cord2) {//check for a slope
		
		double slope=0;
	
		//give all 1s since we have a zero as a rank and also char rep
	    double rankOne = this.m_rank + 1;
		double  fileOne = this.m_file + 1;
        double rankTwo = cord2.m_rank + 1;
		double fileTwo = cord2.m_file + 1;
		
		double denomCheck=fileTwo-fileOne;
		if(denomCheck==0) {
			return false;
		}
		
		else {
		slope=(rankTwo-rankOne)/(fileTwo-fileOne);
		if(slope==1.0||slope==-1.0) {
			return true;
		}
		
		else {
		return false;
		}
		
		}
		
		
		
	
	}
	
	
	/*Conversion methods below to switch from ints or char */
	
	
	/**
	 * takes our current int rep of file and gives back its char
	 *
	 * @param int i
	 * @return char
	 */
	public char getCharFile(int i) {
		char c;
		c= (char)(i+'a');// 
		return c;
	}
	
	/**
	 * to convert the file into an int
	 *
	 * @param char c
	 * @return int tempFile
	 */
	public int getIntFile(char c) {
		String s=(c+"").toLowerCase();//convert the file into an int
		int tempFile=s.charAt(0)-'a';
		return tempFile;
	}

	/**
	 * takes our current int rep of rank and gives back its char
	 *
	 * @param int i
	 * @return char
	 */
	public char getCharRank(int i) {
		char c;
		c=Character.forDigit(i,10);//cause we go from 0-9
		return c;
		
	}
	
	/**
	 * to convert the rank into an int
	 *
	 * @param char c
	 * @return int tempRanks
	 */
	public int getIntRank(char c) {
		int tempRank=Integer.parseInt(c+"");
		return tempRank;
	}
	
	
	
	
	

}
