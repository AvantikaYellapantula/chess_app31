


package com.example.avocado.chess_app31;


import android.widget.Toast;

public class chess_board_view {


    controllerView CV;

    boolean resign;
    boolean draw;


    public chess_board_view(controllerView CV) {
        this.CV=CV;
    }



    /**
     * Tells whether the user-entered argument is accepted or not
     *
     * @param input
     * @return boolean false/true
     */
    public boolean acceptArg(String input) { //takes all inputs
        boolean noMistake = false;

        if(draw==true) {
            if(input.indexOf("draw")!=-1) {
                System.out.println("draw");
              //  System.exit(0);
                CV.isGameOver=true;
                return true;
            }
            else {
                this.draw=false;//they did not accept the draw!
            }
        }

        if(input.indexOf("draw?")!=-1) {
            this.draw=true;
           // return true;
        }


        if (input.equals("resign")) {
            if(CV.board.whiteTurn==true) {
                CV.isGameOver=true;
                CV.whiteResigned=true;
                System.out.print("Black wins");
               // System.exit(0);
                return true;
            }
            else {
                CV.isGameOver=true;
                CV.blackResigned=true;
                System.out.println("White wins");
                //System.exit(0);
                return true;
            }
            //	System.out.println(this.vc.isBlackTurn() ? "White wins!" : "Black wins!");
            //	this.game_board.resign();
        }

        if(input.equals("undo")) {

            return CV.board.undoMove();

        }

        if(input.equals("AI")) {

            return CV.aiMove();
        }
        if (input.length() == 5 || input.contains("draw?")){
            //this.draw=false;
            //that means its the standard input i.e a2 a4 and process the draw

            char rankStart = input.charAt(1); char rankEnd = input.charAt(4);
            //row
            char fileStart = input.charAt(0); char fileEnd = input.charAt(3);
            //col
            //did not specify char for promotion

            noMistake= CV.doMove(fileStart, rankStart, fileEnd, rankEnd,null);




        }

        if(input.length()==7) { //in case a promotion happens
            char rankStart = input.charAt(1); char rankEnd = input.charAt(4);
            char fileStart = input.charAt(0); char fileEnd = input.charAt(3);
            String promote = input.charAt(6)+"";// gave a char to promote

            noMistake= CV.doMove(fileStart, rankStart, fileEnd, rankEnd,promote) ;

        }



        if(noMistake==false) {
            System.out.println("Illegal move, try again");
            return false;
        }

        else {

            return true;
        }


    }


    /**
     * prints the board
     *
     * @param
     * @return none
     */
    public void printBoard() {
        System.out.print( CV.getBoard() );
        System.out.println();
    }

    /**
     * Tells the user to make a move, whether it's the white's turn or black's turn
     *
     * @param
     * @return none
     */
    public void printPrompt() {
        if(CV.isWhiteTurn()) {

            System.out.println();
            System.out.print("White's Move: ");

        }



        else {
            System.out.println();
            System.out.print("Black's Move: ");

        }



    }




}

/*
Sys.Out.Pr
8 bR bN bB bQ bK bB bN bR
7 bP bP bP bP bP bP bP bP
6    ##    ##    ##    ##
5 ##    ##    ##    ##
4	 ##    ##    ##	   ##
3 ## 	## 	  ##    ##
2 wP wP wP wP wP wP wP wP
1 wR wN wB wQ wK wB wN wR
0 1  2  3  4  5  6  7  8
 
 CodeView
0 bR bN bB bQ bK bB bN bR
1 bP bP bP bP bP bP bP bP
2    ##    ##    ##    ##
3 ##    ##    ##    ##
4	 ##    ##    ##	   ##
5 ## 	## 	  ##    ##
6 wP wP wP wP wP wP wP wP
7 wR wN wB wQ wK wB wN wR
8 1  2  3  4  5  6  7  8
 
 
 
 *
 *
 */