package com.example.avocado.chess_app31;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.io.File;
import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity { //look into on naviagtion listener for implementing interface on this class

File file;
ArrayList<String> namesOfGames;
    @Override
    protected void onStart(){
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        /* Execute some code after 4 seconds have passed
            ideally we should find a way to make this execute only the first time the app is opened.
        */
    //    Handler handler = new Handler();

    }
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        //android.os.SystemClock.sleep(7000);
        //showHomeScreen();
    }





public void onCreate(Bundle savedInstance){ // i think bundle is how you save sessions?
    super.onCreate(savedInstance);
    setContentView(R.layout.activity_start);
    final Context thisScreen = this; //look into what a context is

    Button startButton = (Button) findViewById(R.id.start_button);
    startButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent startGame = new Intent(thisScreen, GameActivity.class);
            startActivity(startGame);
        }
    });

    Button view_rcd_Button = (Button) findViewById(R.id.view_rcd_games);
    view_rcd_Button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent viewRCD = new Intent(thisScreen,ListActivity.class); //need to make a class for this
            startActivity(viewRCD);
        }
    });










    //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar); DONT NEED ANY OF THIS TOOLBAR CRAP
    //setSupportActionBar(toolbar);







}




}
