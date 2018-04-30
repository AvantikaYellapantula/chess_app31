package com.example.avocado.chess_app31;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.Image;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.support.v7.widget.GridLayout;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class PlaybackActivity extends AppCompatActivity {

    Game game;
    List<Move> allMoves;
    final Context thisScreen = this;
    ImageView currTile;
    ImageView targetTile;
    int index=-1;
    int sFile;
    int sRank;

    int sView;

    int eFile;
    int eRank;

    int eView;

    //targetTile.setImageDrawable(currTile.getDrawable());
    //    currTile.setImageDrawable(null);
//ImageView currTile,ImageView targetTile



    public void onCreate(Bundle savedInstance) { // i think bundle is how you save sessions?
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_playback);//MAKE SURE TO CHANGE OR RENAME THIS SHIT

        game = (Game) getIntent().getSerializableExtra("game");
        allMoves=game.getAllMoves();






        Button nextButton = (Button) findViewById(R.id.nextButton);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                if(index>=allMoves.size()-1){
                     Toast.makeText(PlaybackActivity.this, "Finished playback",
                            Toast.LENGTH_SHORT).show();
                    return;
                }

                index++;
              Move m=allMoves.get(index);

          sFile =m.startTile.coordinate.m_file;
          sRank =m.startTile.coordinate.m_rank;

          eFile=m.endTile.coordinate.m_file;
          eRank =m.endTile.coordinate.m_rank;


          getSView();

          getEView();


           GridLayout grid= (GridLayout)findViewById(R.id.board_grid);
           ImageView currTile= (ImageView) grid.getChildAt(sView);
           ImageView targetTile=(ImageView) grid.getChildAt(eView);

             targetTile.setImageDrawable(currTile.getDrawable());
             currTile.setImageDrawable(null);

                return;
            }
        });


    }
    public void getSView(){
        int count = 0;
        boolean flag=false;
        for(int i=0; i<8;i++){
            if(flag==true){
                break;
            }
            for(int j=0; j<8;j++){
                if(i==sFile&&j==sRank){
                   flag=true;
                    break;
                }
                        count++;

            }

        }
        sView=count;
    }
    public void getEView(){
        boolean flag=false;
        int count = 0;
        for(int i=0; i<8;i++){
            if(flag==true){
                break;
            }
            for(int j=0; j<8;j++){
                if(i==eFile&&j==eRank){
                    flag=true;
                    break;
                }
                count++;
            }

        }
        eView=count;
    }
}
