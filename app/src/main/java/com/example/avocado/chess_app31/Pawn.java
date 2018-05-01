/**
 * @authors
 * Rahil Chertara
 * Avantika Yellapantula
 */
package com.example.avocado.chess_app31;

public class Pawn extends Piece{
	
	

	public String type = "p";
	

	//actually write the name
	public Pawn(boolean color) {
		super(color);
	}//constructor
	
	/**
	 * Overrides the toString Method
	 *

	 * @return String color+type
	 */
	public String toString() {
		if(color==true) {
			//white pawn
			return  "w" + this.type;
		}else {
			//black pawn
			return  "b" + this.type;
		}
	}
	
	
    public boolean enpassantFlag;
  
    /**
	 * This method gives the 'ok' to make the move in terms of distance. It uses the distance formula to check whether the bishop can move in the user-desired direction. 
	 *
	 * irCoordinate end,allCases specialCase
	 * @return boolean false/true, whether it's 'ok' to move
	 */
	public boolean isOkMove(PairCoordinate start, PairCoordinate end,allCases specialCase) {
	 

		  
	if(specialCase.isCapturing==true) {
		
		if(color==true) {//white
			
			 if((start.m_rank==end.m_rank+1 && start.m_file+1==end.m_file) || (start.m_rank==end.m_rank+1 && start.m_file-1==end.m_file) ) {
					//return true;

				 return true;
			  }
			
			 
			  else {
				//	System.out.println("Pawn cant capture like that");
					return false;
				}
			  
		  }
		
		else {
			
			if((start.m_rank+1==end.m_rank && start.m_file+1==end.m_file) || (start.m_rank+1==end.m_rank && start.m_file-1==end.m_file) ) {
				//return true;

				return true;
	         }
			
			  else {
				//	System.out.println("Pawn cant capture like that");
					return false;
				   } 
		
		}
		
	}

		   
   	        
   	      
   	  if(specialCase.pieceInPath==false) {
		
	  if(color==true) {
		 
		  if(start.m_rank==6) {//white pawn start
			 specialCase.isFirstMove=true;
			  //  specialCase.checkEnPassant=true;
		  }
		  if(end.m_rank==0) {
			//  specialCase.isPromoting=true;
		//	  return true;//has made it to promotion
		  }
		  
	  }
	  
	  if(color==false) {   
		  if(start.m_rank==1) {//black pawn start 
			  specialCase.isFirstMove=true;
			 // specialCase.checkEnPassant=true;
		  }

	  }
      
       if(specialCase.isFirstMove==true) { //FIRST MOVE
    		if(start.isSameFile(end)==false) {
    		   return false;
    		}
    		
    		if( start.m_rank + 1 == end.m_rank &&color==false) {
    			
    	    	return true;
    	    }
    		
    		if( start.m_rank - 1 == end.m_rank &&color==true) {
        	    return true;
        	}
    		
    		if( start.m_rank + 2 == end.m_rank &&color==false&&specialCase.isFirstMove==true){
    		//	enpassantFlag=true;//only if it moves two spaces then set
    			return true;
    		}
    		if( start.m_rank - 2 == end.m_rank &&color==true&&specialCase.isFirstMove==true) {
    		//	enpassantFlag=true;
    			return true;
    		}
    		
     
      
      }
    
    
    else {//NOT FIRST MOVE
    	
    	
    			
    		if(color==false) { 
    		
    	
    		if((start.isSameFile(end)) && (start.m_rank+1==end.m_rank) ) {
    		return true;
   
    		}
    		
    	
    		
    		
    		
    		
    	 }
    
    	 else {
    		
    		if(start.isSameFile(end) && (start.m_rank-1==end.m_rank)){
    			return true;
    			}
    		

    		

    			
    		
    		//(start.m_file-1==end.m_file && start.m_rank-1==end.m_rank)
    		
    		}
    	
    		return false;
    }
   
    
   
	
	}
	
   	  //else{  has piece in path 
   	     
		return false;
	
	
	}
	
	
	

}
