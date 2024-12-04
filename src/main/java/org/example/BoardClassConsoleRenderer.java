package org.example;

import org.example.figure.Piece;

public class BoardClassConsoleRenderer {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_WHITE_PIECE_COLOR = "\u001B[97m";
    public static final String ANSI_BLACK_PIECE_COLOR = "\u001B[30m";
    public static final String ANSI_WHITE_SQUARE_BACKGROUND = "\u001B[47m";
    public static final String ANSI_BLACK_SQUARE_BACKGROUND = "\u001B[100m";

    public void render(Board board) {
        for (int rank = 8; rank >= 1; rank--) {
            String line = "";
            for (File file : File.values()) {
                Coordinates coordinates = new Coordinates(file, rank);
                if (board.isSquareEmpty(coordinates)) {
                    line += getSpriteForEmptySquare(coordinates);
                }
                else {
                    line += getSpritePiece(board.getPiecesCoordinate(coordinates));
                }
            }
            line += ANSI_RESET;

            System.out.println(line);

        }
    }

    private String ColorizeSpriteForBoardSquare(String sprite, Color pieceColor , boolean isSquareDark){
        String result = sprite;

        if(pieceColor == Color.WHITE){
            result = ANSI_WHITE_PIECE_COLOR + result;
        }
        else{
            result = ANSI_BLACK_PIECE_COLOR + result;
        }

        if(isSquareDark){
            result = ANSI_BLACK_SQUARE_BACKGROUND + result;
        }
        else{
            result = ANSI_WHITE_SQUARE_BACKGROUND + result;
        }

        return result;
    }

    private String getSpriteForEmptySquare(Coordinates coordinates ){
        return ColorizeSpriteForBoardSquare("  \u2003", Color.WHITE, Board.isSquareDark(coordinates));
    }

    private String selectSpriteForPiece(Piece piece) {
        switch (piece.getClass().getSimpleName()) {
            case "King":
                return " ♔ ";
            case "Queen":
                return " ♕ ";
            case "Knight":
                return " ♘ ";
            case "Pawn":
                return " ♙ ";
            case "Rook":
                return " ♖ ";
            case "Bishop":
                return " ♗ ";
            default:
                return "";
        }
    }

    private String getSpritePiece(Piece piece){
        return ColorizeSpriteForBoardSquare(selectSpriteForPiece(piece), piece.color, Board.isSquareDark(piece.coordinates));
    }
}
