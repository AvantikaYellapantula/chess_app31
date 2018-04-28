

package com.example.avocado.chess_app31;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

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


        Button yesButton = (Button) findViewById(R.id.yesButton);
        yesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                gameList.getGameList().add(game);
                 GameList.Save(gameList);


                Intent intent = new Intent(thisScreen, HomeActivity.class); //need to make a class for this
                startActivity(intent);
            }
        });

        Button noButton = (Button) findViewById(R.id.noButton);
        noButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisScreen, HomeActivity.class); //need to make a class for this
                startActivity(intent);
            }
        });



    }


}

