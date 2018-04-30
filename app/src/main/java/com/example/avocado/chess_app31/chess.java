/**
 * @authors
 * Rahil Chertara
 * Avantika Yellapantula
 */


package chess;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


import controller.controllerView;
import model.Board;
import model.Tile;
import view.chess_board_view;

public class chess {
	static String fileName="file";

	public static void main(String[] args){
	
		Scanner input= new Scanner(System.in);
		// TODO Auto-generated method stub
		controllerView gameController= new controllerView();
		
		chess_board_view gameView= new chess_board_view(gameController);
		
		
		controllerView copyController= new controllerView();//for checkmate
		
		
		//String allInputs[]=parse();
		
		//int p=0;
		
		while(gameController.isGameOver!=true) {
			
			//first thing is always check for checkMate
			
			if(gameController.board.checkFlag==true) {
				
				char[] letters= {'a','b','c','d','e','f','g','h'};
				char[] nums= {'1','2','3','4','5','6','7','8'};
				
				String promo=null;
				
				copyController.board=gameController.board.copyBoard();//will need a copy to do moves on the board!
				boolean gotOutOfCheck = false;
				
				if(gameController.board.whiteTurn==true) {
				
					
						
					   for(int i=0;i<8;i++) {
						   if(gotOutOfCheck==true) {
								break;
							}
						   for(int j=0;j<8;j++) {
							   if(gotOutOfCheck==true) {
									break;
								}
							   for(int k=0;k<8;k++){
								   if(gotOutOfCheck==true) {
										break;
									}
								   for(int m=0;m<8;m++) {
									   
									   
				gotOutOfCheck=copyController.doMove(letters[i], nums[j], letters[k], nums[m], promo);
				copyController.board=gameController.board.copyBoard();
				if(gotOutOfCheck==true) {
					break;
				}
								   }
							   }
						   }
					   }
						
				if(gotOutOfCheck==false) {
					System.out.println("Checkmate");
					System.out.println("Black wins");
					System.exit(0);
				}
				else {
					System.out.println("Check");
				}
				
						
					
				}
				
				
				
				
				
				else {
					
					
					   for(int i=0;i<8;i++) {
						   if(gotOutOfCheck==true) {
								break;
							}
						   for(int j=0;j<8;j++) {
							   if(gotOutOfCheck==true) {
									break;
								}
							   for(int k=0;k<8;k++){
								   if(gotOutOfCheck==true) {
										break;
									}
								   for(int m=0;m<8;m++) {
									   
									   
				gotOutOfCheck=copyController.doMove(letters[i], nums[j], letters[k], nums[m], promo);
				copyController.board=gameController.board.copyBoard();
				if(gotOutOfCheck==true) {
					break;
				}
								   }
							   }
						   }
					   }
						
				if(gotOutOfCheck==false) {
					System.out.println("Checkmate");
					System.out.println("White wins");
					System.exit(0);
				}
				else {
					System.out.println("Check");
				}
						
					
				}
				
				
				
			}
				
			
			
			
			
			gameView.printBoard();
			gameView.printPrompt();
			
			
		    
			
			String strInput;
			boolean noMistake=false;
			
			
			
			
			while(noMistake==false) {
				
			
				
				
				 //else {
				
				strInput=input.nextLine();
				
				
			//	String allInputs[]=parse();
				System.out.println();
				
				//System.out.println(strInput);
						
		    	noMistake=gameView.acceptArg(strInput);
		    	
		    	if(noMistake==false) {
		    		//p++;
		    	//gameView.printBoard();
		    	gameView.printPrompt();
		    	 }
		    	
			//	 }
		    	
				 //System.out.println();
		    
			}
			
		//p++;
		
		}
		
		
		
		
	}


	/**
	 * For Testing Purposes
	 *
	 * @param none
	 * @return allInputs
	 */
	public static String[] parse(){
		String text="";
		BufferedReader buffer = null;
		String allInputs[]=new String[500];
		try {
			buffer = new BufferedReader(new FileReader("src/chess/"+fileName));
		}catch(FileNotFoundException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
	      
			try {
				int i=0;
				while((text=buffer.readLine())!=null) {
				
				allInputs[i]=text;
				i++;
			
				}
				//SongNode newNode=new SongNode(textArray[0],textArray[1],textArray[2],textArray[3]);	
				
			//MUST MAKE A CATCH HERE FOR if songs are dupliate 
			
				
					
				}
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return allInputs;
			} 
  
			
	}


