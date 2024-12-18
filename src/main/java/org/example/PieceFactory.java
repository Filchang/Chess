package org.example;

import org.example.figure.*;

public class PieceFactory {

    Piece pieceFromFen(char fenChar, Coordinates coordinates) {

        switch (fenChar) {
            case 'p':
                return new Pawn(Color.WHITE, coordinates);
            case 'P':
                return new Pawn(Color.BLACK, coordinates);
            case 'r':
                return new Rook(Color.WHITE, coordinates);
            case 'R':
                return new Rook(Color.BLACK, coordinates);
            case 'b':
                return new Bishop(Color.WHITE, coordinates);
            case 'B':
                return new Bishop(Color.BLACK, coordinates);
            case 'k':
                return new King(Color.WHITE, coordinates);
            case 'K':
                return new King(Color.BLACK, coordinates);
            case 'q':
                return new Queen(Color.WHITE, coordinates);
            case 'Q':
                return new Queen(Color.BLACK, coordinates);
            case 'n':
                return new Knight(Color.WHITE, coordinates);
            case 'N':
                return new Knight(Color.BLACK, coordinates);
            default:
                throw new RuntimeException("Неизвестный фен");

        }
    }
}
