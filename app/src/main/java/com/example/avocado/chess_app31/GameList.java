package com.example.avocado.chess_app31;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GameList implements Serializable{
    private static final long serialVersionUID = 9098326388219881911L;

    public static final String storeFile = "users.store";
   // public static final String storeDir = "src/store";

    List<Game> allGames;

    public GameList() {
        this.allGames= new ArrayList<Game>();
    }



    public List<Game> getGameList(){

        return this.allGames;
    }


    public static void Save (GameList gamelist)  {

        ObjectOutputStream output = null;
        try {
            output = new ObjectOutputStream(new FileOutputStream(storeFile));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try {
            output.writeObject(gamelist);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try {
            output.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public static GameList getData() throws FileNotFoundException, IOException {
        FileInputStream saveFile=new FileInputStream(storeFile);

        if(saveFile.available()==0) {
            GameList userlist= new GameList();
            return userlist;
            //ObjectInputStream oes=new ObjectInputStream(saveFile);
        }

        ObjectInputStream input=new ObjectInputStream(saveFile);

        //ObjectInputStream ois = new ObjectInputStream(new FileInputStream(storeDir+"/"+storeFile));


        GameList userlist = null;
        try {
            userlist = (GameList) input.readObject();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }//this gives us back our list

        input.close();

        return userlist;

    }




}
