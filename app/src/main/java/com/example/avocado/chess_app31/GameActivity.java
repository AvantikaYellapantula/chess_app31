package com.example.avocado.chess_app31;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class GameActivity extends AppCompatActivity {

    static String fileName = "file";
    private static GameList gamelist;
    public boolean firstSelect=true;
    public String strInput;

   public ImageView currTile;
   public ImageView targetTile;


    Scanner input; //take this out later
    controllerView gameController;
    chess_board_view gameView;
    controllerView copyController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gamescreen);

          input= new Scanner(System.in);//take this out later
          gameController = new controllerView();
          gameView = new chess_board_view(gameController);
          copyController = new controllerView();//for checkmate

    }






    public void handleInput(View selectTile) { //does not handle promotion yet

        if (firstSelect == true) {
            currTile = (ImageView) selectTile;
            if (currTile.getDrawable() == null) {
                return; //that means first tile has no piece on it so no point to handle this
            }

            String tileSpot = getResources().getResourceName(currTile.getId());//this will give us a3
            strInput = strInput += tileSpot; //put this in the input string
            firstSelect = false;//flick switch
        } else {
            targetTile = (ImageView) selectTile;
            String tileSpot = getResources().getResourceName(targetTile.getId());
            strInput = strInput + " " + tileSpot;//get full input string
            firstSelect = true;//flick switch


            if (gameController.isGameOver != true) {

                //first thing is always check for checkMate

                if (gameController.board.checkFlag == true) {

                    char[] letters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
                    char[] nums = {'1', '2', '3', '4', '5', '6', '7', '8'};

                    String promo = null;

                    copyController.board = gameController.board.copyBoard();//will need a copy to do moves on the board!
                    boolean gotOutOfCheck = false;

                    if (gameController.board.whiteTurn == true) {


                        for (int i = 0; i < 8; i++) {
                            if (gotOutOfCheck == true) {
                                break;
                            }
                            for (int j = 0; j < 8; j++) {
                                if (gotOutOfCheck == true) {
                                    break;
                                }
                                for (int k = 0; k < 8; k++) {
                                    if (gotOutOfCheck == true) {
                                        break;
                                    }
                                    for (int m = 0; m < 8; m++) {


                                        gotOutOfCheck = copyController.doMove(letters[i], nums[j], letters[k], nums[m], promo);
                                        copyController.board = gameController.board.copyBoard();
                                        if (gotOutOfCheck == true) {
                                            break;
                                        }
                                    }
                                }
                            }
                        }

                        if (gotOutOfCheck == false) {


                            System.out.println("Checkmate");
                            System.out.println("Black wins");


                            System.out.println("Enter a name for the game played");

                            String title = input.nextLine();

                            Game game = new Game(gameController.board.allMoves, title);

                            gamelist.getGameList().add(game); //add the game to overall list of games

                            GameList.Save(gamelist); //save this game to list of all games played


                            System.exit(0);
                        } else {
                            System.out.println("Check");
                        }


                    } else {


                        for (int i = 0; i < 8; i++) {
                            if (gotOutOfCheck == true) {
                                break;
                            }
                            for (int j = 0; j < 8; j++) {
                                if (gotOutOfCheck == true) {
                                    break;
                                }
                                for (int k = 0; k < 8; k++) {
                                    if (gotOutOfCheck == true) {
                                        break;
                                    }
                                    for (int m = 0; m < 8; m++) {


                                        gotOutOfCheck = copyController.doMove(letters[i], nums[j], letters[k], nums[m], promo);
                                        copyController.board = gameController.board.copyBoard();
                                        if (gotOutOfCheck == true) {
                                            break;
                                        }
                                    }
                                }
                            }
                        }

                        if (gotOutOfCheck == false) {
                            System.out.println("Checkmate");
                            System.out.println("White wins");

                            System.out.println("Enter a name for the game played");

                            String title = input.nextLine();

                            Game game = new Game(gameController.board.allMoves, title);

                            gamelist.getGameList().add(game); //add the game to overall list of games

                            GameList.Save(gamelist); //save this game to list of all games played
                            System.exit(0);
                        } else {
                            System.out.println("Check");
                        }


                    }


                }


                gameView.printBoard();
                gameView.printPrompt();


                // String strInput=handleInput();
                boolean noMistake = false;


                while (noMistake == false) {


                    //else {

                    //  strInput = input.nextLine(); this is for console entering*********


                    //	String allInputs[]=parse();
                    System.out.println();

                    //System.out.println(strInput);
                    //strInput=allInputs[p];

                    //noMistake=gameView.acceptArg(strInput);


                    noMistake = gameView.acceptArg(strInput);
                    strInput = "";

                    ;//took an input from board now reset it for next input


                    if (noMistake == false) {

                        gameView.printBoard();
                        gameView.printPrompt();

                        // targetTile.setImageDrawable(currTile.getDrawable());
                        //currTile.setImageDrawable(null);


                    } else {
                        Toast.makeText(GameActivity.this, "Illegal Move",
                                Toast.LENGTH_SHORT).show();
                        firstSelect = true;

                    }
                    //	 }

                    //System.out.println();

                }

                //p++;

            }

        }

    }





}



