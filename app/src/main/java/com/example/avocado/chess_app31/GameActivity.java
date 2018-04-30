package com.example.avocado.chess_app31;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

import static com.example.avocado.chess_app31.GameList.getData;

public class GameActivity extends AppCompatActivity {
    public transient Context thisScreen = this;
    static String fileName = "file";

    private static GameList gamelist;
    private static Game game;

    public boolean firstSelect = true;
    public boolean drawAllowed=false;
    public boolean drawPressed=false;



    public String strInput = "";

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
        gamelist = new GameList();


        try {
            FileInputStream fis= openFileInput("games.dat");
            if(fis.available()!=0) {
                ObjectInputStream os = new ObjectInputStream(fis);
                gamelist = (GameList) os.readObject();
                os.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        gameController = new controllerView();
        gameView = new chess_board_view(gameController);
        copyController = new controllerView();//for checkmate

        gameView.printBoard();
        gameView.printPrompt();

        ImageButton undoButton = findViewById(R.id.undo_button);
        undoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent startGame = new Intent(thisScreen, GameActivity.class);
                // //startActivity(startGame);
                strInput = "undo";
                runInput();
            }
        });

        Button drawButton =  findViewById(R.id.draw_button);
        drawButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent startGame = new Intent(thisScreen, GameActivity.class);
                // //startActivity(startGame);
                drawPressed=true;

                Toast.makeText(GameActivity.this, "make a valid move to extend this draw",
                        Toast.LENGTH_SHORT).show();

            }
        });
        Button acceptDrawButton =  findViewById(R.id.acceptDrawBtn);
        acceptDrawButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent startGame = new Intent(thisScreen, GameActivity.class);
                // //startActivity(startGame);
               if(drawAllowed==true&&gameView.draw==true) {
                   strInput = "draw";
                   runInput();
               }
               else{
                   Toast.makeText(GameActivity.this, "A draw must be offered first!!!",
                           Toast.LENGTH_SHORT).show();
                   return;
               }

            }
        });

        Button resignButton = findViewById(R.id.resign_button);
        resignButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent startGame = new Intent(thisScreen, GameActivity.class);
                // //startActivity(startGame);
                strInput = "resign";
                runInput();
            }
        });

    }


    public void checkOrCheckmate() {

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

                    Toast.makeText(GameActivity.this, "White in checkmate, Black wins ",
                            Toast.LENGTH_SHORT).show();

/*
                            System.out.println("Enter a name for the game played");

                            String title = input.nextLine();

                            Game game = new Game(gameController.board.allMoves, title);

                            gamelist.getGameList().add(game); //add the game to overall list of games

                            GameList.Save(gamelist); //save this game to list of all games played
*/

                    // System.exit(0);
                    gameController.isGameOver = true;
                } else {
                    System.out.println("Check");
                    // Toast.makeText(GameActivity.this, "White in check ",
                    //       Toast.LENGTH_SHORT).show();
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
                    Toast.makeText(GameActivity.this, "Black in checkmate, White wins ",
                            Toast.LENGTH_SHORT).show();
                               /*
                            System.out.println("Enter a name for the game played");

                            String title = input.nextLine();

                            Game game = new Game(gameController.board.allMoves, title);

                            gamelist.getGameList().add(game); //add the game to overall list of games

                            GameList.Save(gamelist); //save this game to list of all games played
                            */
                    gameController.isGameOver = true;
                } else {
                    System.out.println("Check");
                    Toast.makeText(GameActivity.this, "Black in check ",
                            Toast.LENGTH_SHORT).show();
                }


            }


        }
    }

    public void changeBoardImages(){

      //  int l= gameController.board.allMoves.size()-1;
       // Move m=gameController.board.allMoves.get(l);

      //  m.currTile=currTile;
        // m.targetTile=targetTile;

        targetTile.setImageDrawable(currTile.getDrawable());
        currTile.setImageDrawable(null);

    }


    public void runInput() {
        boolean noMistake = false;

        while (noMistake == false) {


            //else {

            //  strInput = input.nextLine(); this is for console entering*********


            //	String allInputs[]=parse();
            System.out.println();

            //System.out.println(strInput);
            //strInput=allInputs[p];

            //noMistake=gameView.acceptArg(strInput);
            if(drawPressed){
                strInput=strInput+"draw?";
                noMistake = gameView.acceptArg(strInput);
                strInput = "";
                if(noMistake==true){
                    drawAllowed=true;
                    drawPressed=false;
                }

            }
            else {
                noMistake = gameView.acceptArg(strInput);
                strInput = "";
            }
            //took an input from board now reset it for next input




            if (noMistake == false) {
                Toast.makeText(GameActivity.this, "Illegal Move",
                        Toast.LENGTH_SHORT).show();
                firstSelect = true;
                // gameView.printBoard();
                gameView.printPrompt();
                return;
                //  targetTile.setImageDrawable(currTile.getDrawable());
                // currTile.setImageDrawable(null);
                //return;

            } else {

                if(gameController.isGameOver==true){
                    return;
                    //we dont want it settting images during a resign or ddraw
                }


                changeBoardImages();


                checkOrCheckmate();

                if (gameController.board.whiteTurn == true) { //this code is working for showing turn but not good
                    TextView turnLabel = findViewById(R.id.turnLabel);
                    turnLabel.setText("White's Move");
                } else {
                    TextView turnLabel = findViewById(R.id.turnLabel);
                    turnLabel.setText("Blacks's Move");
                }
                gameView.printBoard();
                gameView.printPrompt();


                return;

            }
            //	 }

            //System.out.println();

        }

    }



    public void goToStoreScreen(){

        game = new Game(gameController.board.allMoves, "");
        Intent storeGame = new Intent(thisScreen, storeActivity.class);
       storeGame.putExtra("game",game );
       storeGame.putExtra("gameList",gamelist);
        startActivity(storeGame);
      //  return;
    }

    public void handleInput(View selectTile) { //does not handle promotion yet

        if(gameController.whiteResigned==true){
            Toast.makeText(GameActivity.this, "White resigned black wins",
                    Toast.LENGTH_SHORT).show();

            goToStoreScreen();
        }
        if(gameController.blackResigned==true){
            Toast.makeText(GameActivity.this, "Black resigned white wins",
                    Toast.LENGTH_SHORT).show();
            goToStoreScreen();
        }

        if(gameController.isGameOver==true&&gameView.draw==true){
            Toast.makeText(GameActivity.this, "Game is finished, with a draw",
                    Toast.LENGTH_SHORT).show();
            goToStoreScreen();

        }

        if (gameController.isGameOver == true) {
            Toast.makeText(GameActivity.this, "Game is finished",
                    Toast.LENGTH_SHORT).show();
            goToStoreScreen();
        }

        if (firstSelect == true) {
            currTile = (ImageView) selectTile;
            if (currTile.getDrawable() == null) {
                return; //that means first tile has no piece on it so no point to handle this
            }

            String tileSpot = getResources().getResourceName(currTile.getId());//this will give us a3
            strInput = strInput += tileSpot.substring(tileSpot.length() - 2); //put this in the input string
            firstSelect = false;//flick switch
        } else {
            targetTile = (ImageView) selectTile;
            String tileSpot = getResources().getResourceName(targetTile.getId());
            strInput = strInput + " " + tileSpot.substring(tileSpot.length() - 2);//get full input string
            firstSelect = true;//flick switch

           //turn off the draw since the player choose to make a move instead of accept

            drawAllowed=false;
            runInput();

        }


    }

}

