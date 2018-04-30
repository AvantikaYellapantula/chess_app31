package com.example.avocado.chess_app31;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.List;

public class PlaybackActivity extends AppCompatActivity {

    Game game;
    List<Move> allMoves;
    final Context thisScreen = this;
    ImageView currTile;
    ImageView targetTile;
    int index=-1;
    //targetTile.setImageDrawable(currTile.getDrawable());
    //    currTile.setImageDrawable(null);
//ImageView currTile,ImageView targetTile
    public void onCreate(Bundle savedInstance) { // i think bundle is how you save sessions?
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_playback);//MAKE SURE TO CHANGE OR RENAME THIS SHIT

        game = (Game) getIntent().getSerializableExtra("game");
        allMoves=game.getAllMoves();




        Button prevButton = (Button) findViewById(R.id.prevButton);
       prevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        Button nextButton = (Button) findViewById(R.id.nextButton);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(index>allMoves.size()-1){
                    return;
                }

                index++;
              Move m=allMoves.get(index);
           int a=   m.startTile.coordinate.m_file;
           int b=m.endTile.coordinate.m_file;

           currTile= getResources().

             // currTile=m.currTile;
             // targetTile=m.targetTile;
             // targetTile.setImageDrawable(currTile.getDrawable());
              //currTile.setImageDrawable(null);


            }
        });
    }
}
