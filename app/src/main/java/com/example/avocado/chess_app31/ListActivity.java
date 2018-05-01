package com.example.avocado.chess_app31;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListActivity extends AppCompatActivity {
    private GameList gamelist;

    List<Game> games;

    public void onCreate(Bundle savedInstance) { // i think bundle is how you save sessions?
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_rec_list);
        final Context thisScreen = this; //look into what a context is
        try {
            FileInputStream fis = openFileInput("games.dat");
            ObjectInputStream os = new ObjectInputStream(fis);
            gamelist = (GameList) os.readObject();
            if (gamelist != null) {
                games = gamelist.getGameList();
            } else {
                games = new ArrayList<Game>();
            }
            os.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        if(games==null){
            Toast.makeText(ListActivity.this, "you must first play some games and save, can not view empty list!",
                    Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(thisScreen, HomeActivity.class); //need to make a class for this
            startActivity(intent);
        return;
        }

        Game[] gameArray = new Game[games.size()];

        ArrayAdapter<Game> adapter = new ArrayAdapter<Game>(this, android.R.layout.simple_list_item_1, (Game[]) games.toArray(gameArray));

        ListView lv = (ListView) findViewById(R.id.rec_list);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(thisScreen, PlaybackActivity.class);
           //     Bundle b = new Bundle();
                Game game = games.get(position);
             //   b.putSerializable("game", game);
                i.putExtra("game",game);
                startActivity(i);


            }
        });


        Button startButton = (Button) findViewById(R.id.date_sort);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            doSortDate();
            }
        });

        Button view_rcd_Button = (Button) findViewById(R.id.title_sort);
        view_rcd_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            doSortTitle();
            }
        });

    }



    public void doSortTitle(){
       Collections.sort(games,new Game.SortbyTitle());
        Game[] gameArray = new Game[games.size()];

        ArrayAdapter<Game> adapter = new ArrayAdapter<Game>(this, android.R.layout.simple_list_item_1, (Game[]) games.toArray(gameArray));

        ListView lv = (ListView) findViewById(R.id.rec_list);
        lv.setAdapter(adapter);
    }

    public void doSortDate(){
        Collections.sort(games,new Game.SortbyDate());
        Game[] gameArray = new Game[games.size()];

        ArrayAdapter<Game> adapter = new ArrayAdapter<Game>(this, android.R.layout.simple_list_item_1, (Game[]) games.toArray(gameArray));

        ListView lv = (ListView) findViewById(R.id.rec_list);
        lv.setAdapter(adapter);
    }
}
