package org.example;

import org.example.figure.Piece;

import java.util.Set;

public class Main {
    public static void main(String[] args) {
       /* Board board = new Board();
        board.setupDefaultPiecePositions();



        Piece piece = board.getPiecesCoordinate(new Coordinates(File.G, 8));
        Set<Coordinates> availableMoveSquares = piece.getAvailableMoveCoordinates(board);

        int a = 123;*/
        Board board = (new BoardFactory()).CheesFen("8/8/8/6N1/1n6/8/3B4/3R4 w - - 0 1");

        BoardClassConsoleRenderer boardClassConsoleRenderer = new BoardClassConsoleRenderer();
        boardClassConsoleRenderer.render(board);

      /*  Game game = new Game(board);
        game.gameLogic();
*/
    }
}