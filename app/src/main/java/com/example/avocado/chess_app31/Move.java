package com.example.avocado.chess_app31;

import android.widget.ImageView;

import java.io.Serializable;



public class Move implements Serializable {
    private static final long serialVersionUID = 6955723612371190680L;

    Piece movingPiece;
    Piece endPiece;

    Tile startTile;
    Tile endTile;
    public ImageView currTile;
    public ImageView targetTile;
    //targetTile.setImageDrawable(currTile.getDrawable());
    //    currTile.setImageDrawable(null);
//ImageView currTile,ImageView targetTile
    public Move(Piece movingPiece,Piece endPiece, Tile startTile,Tile endTile) {

        this.movingPiece=movingPiece;
        this.endPiece=endPiece;
        this.startTile=startTile;
        this.endTile=endTile;
      //  this.currTile=currTile;
       // this.targetTile=targetTile;


        //startTile.coordinate.
    }







}