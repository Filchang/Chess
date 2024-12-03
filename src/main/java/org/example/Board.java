package org.example;

import org.example.figure.Pawn;
import org.example.figure.Piece;

import java.util.HashMap;

public class Board {
     HashMap<Coordinates, Piece> PiecePosition = new HashMap<>();

     public void setPiece(Coordinates coordinates, Piece piece){
         piece.coordinates = coordinates;
         PiecePosition.put(coordinates,piece);
     }

     public void setupDefaultPiecePositions(){
         //set pawns
         for(File file: File.values()){
             setPiece(new Coordinates(file,2),new Pawn(Color.WHITE, new Coordinates(file,2)));
             setPiece(new Coordinates(file,7),new Pawn(Color.BLACK, new Coordinates(file,7)));
         }

         //set rock
         setPiece(new Coordinates(File.A,1),new Pawn(Color.WHITE, new Coordinates(File.A,1)));
         setPiece(new Coordinates(File.H,1),new Pawn(Color.WHITE, new Coordinates(File.H,1)));
         setPiece(new Coordinates(File.A,8),new Pawn(Color.BLACK, new Coordinates(File.A,8)));
         setPiece(new Coordinates(File.H,8),new Pawn(Color.BLACK, new Coordinates(File.H,8)));

         //set knight
         setPiece(new Coordinates(File.B,1),new Pawn(Color.WHITE, new Coordinates(File.B,1)));
         setPiece(new Coordinates(File.G,1),new Pawn(Color.WHITE, new Coordinates(File.G,1)));
         setPiece(new Coordinates(File.B,8),new Pawn(Color.BLACK, new Coordinates(File.B,8)));
         setPiece(new Coordinates(File.G,8),new Pawn(Color.BLACK, new Coordinates(File.G,8)));

         //set bishop
         setPiece(new Coordinates(File.C,1),new Pawn(Color.WHITE, new Coordinates(File.C,1)));
         setPiece(new Coordinates(File.F,1),new Pawn(Color.WHITE, new Coordinates(File.F,1)));
         setPiece(new Coordinates(File.C,8),new Pawn(Color.BLACK, new Coordinates(File.C,8)));
         setPiece(new Coordinates(File.F,8),new Pawn(Color.BLACK, new Coordinates(File.F,8)));

         //set queen
         setPiece(new Coordinates(File.E,1),new Pawn(Color.WHITE, new Coordinates(File.E,1)));
         setPiece(new Coordinates(File.E,8),new Pawn(Color.BLACK, new Coordinates(File.E,8)));

         //ser king
         setPiece(new Coordinates(File.D,1),new Pawn(Color.WHITE, new Coordinates(File.D,1)));
         setPiece(new Coordinates(File.D,8),new Pawn(Color.BLACK, new Coordinates(File.D,8)));
     }
}
