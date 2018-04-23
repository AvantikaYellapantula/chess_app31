package com.example.avocado.chess_app31;

import java.io.Serializable;



public class Move implements Serializable {
    private static final long serialVersionUID = 6955723612371190680L;

    Piece movingPiece;
    Piece endPiece;

    Tile startTile;
    Tile endTile;


    public Move(Piece movingPiece,Piece endPiece, Tile startTile,Tile endTile) {

        this.movingPiece=movingPiece;
        this.endPiece=endPiece;
        this.startTile=startTile;
        this.endTile=endTile;


        //startTile.coordinate.
    }







}