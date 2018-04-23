package com.example.avocado.chess_app31;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.List;

public class Game implements Serializable{
    private static final long serialVersionUID = 361483182394865003L;

    List<Move> allMoves;
    private Calendar calendrier;
    String Title;


    public Game(List<Move> allMoves,String Title) {
        this.allMoves= allMoves;
        this.Title=Title;


        calendrier = Calendar.getInstance();
        calendrier.set(Calendar.MILLISECOND, 0);

    }


    class SortbyDate implements Comparator<Game>
    {

        @Override
        public int compare(Game arg0, Game arg1) {
            // TODO Auto-generated method stub
            return arg0.calendrier.compareTo(arg1.calendrier);


        }
        // Used for sorting in ascending order of
        // roll number

    }

    class SortbyTitle implements Comparator<Game>
    {

        @Override
        public int compare(Game arg0, Game arg1) {
            // TODO Auto-generated method stub
            return arg0.Title.compareTo(arg1.Title);
        }
        // Used for sorting in ascending order of
        // roll name

    }





}
