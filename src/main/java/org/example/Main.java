package org.example;

import org.example.figure.Piece;

import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        board.setupDefaultPiecePositions();
        /*BoardClassConsoleRenderer boardClassConsoleRenderer = new BoardClassConsoleRenderer();
        boardClassConsoleRenderer.render(board);

        Piece piece = board.getPiecesCoordinate(new Coordinates(File.G, 8));
        Set<Coordinates> availableMoveSquares = piece.getAvailableMoveCoordinates(board);

        int a = 123;*/

        Game game = new Game(board);
        game.gameLogic();

    }
}