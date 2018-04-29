

package com.example.avocado.chess_app31;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class storeActivity extends AppCompatActivity {
    final Context thisScreen = this;

    String nameOfGame;
    GameList gameList;
    Game game;

    public void SetGame(Game game) {
        this.game = game;
    }

    public void SetGameList(GameList gameList) {
        this.gameList = gameList;
    }


    public void onCreate(Bundle savedInstance) { // i think bundle is how you save sessions?
        super.onCreate(savedInstance);
        setContentView(R.layout.layout);//MAKE SURE TO CHANGE OR RENAME THIS SHIT

        game = (Game) getIntent().getSerializableExtra("game");
        gameList = (GameList) getIntent().getSerializableExtra("gameList");




        Button yesButton = (Button) findViewById(R.id.yes_button);
        yesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextInputEditText nameOfGame= (TextInputEditText)findViewById(R.id.nameOfGame);
                String name="";
                name=nameOfGame.getText().toString().trim();//i think this will give string

                game.Title=name; //set name to what user gives
                gameList.getGameList().add(game);

                try {
                    FileOutputStream fis= openFileOutput("games.dat",Context.MODE_PRIVATE);
                    ObjectOutputStream os = new ObjectOutputStream(fis);
                    os.writeObject(gameList);
                    os.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }


                Intent intent = new Intent(thisScreen, HomeActivity.class); //need to make a class for this
                startActivity(intent);
            }
        });

        Button noButton = (Button) findViewById(R.id.no_button);
        noButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisScreen, HomeActivity.class); //need to make a class for this
                startActivity(intent);
            }
        });



    }


}

