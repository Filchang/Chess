package org.example;

import org.example.figure.InputCoordinates;
import org.example.figure.Piece;

import java.util.Set;

public class Game {
    Board board = new Board();
    BoardClassConsoleRenderer renderer = new BoardClassConsoleRenderer();
    public Game(Board board) {
        this.board = board;
    }

    public void gameLogic(){

        boolean isPieceWhite = true;

        while(true){

            renderer.render(board);

            Coordinates startCoordinates = InputCoordinates.inputCoordinatesForPieceColor(isPieceWhite ? Color.WHITE : Color.BLACK, board);

            Piece piece = board.getPiecesCoordinate(startCoordinates);
            Set<Coordinates> availableMoveCoordinates = piece.getAvailableMoveCoordinates(board);

            Coordinates coordinatesForMove = InputCoordinates.availableSquareForMove(availableMoveCoordinates);

            board.movePiece(startCoordinates, coordinatesForMove);

            isPieceWhite =! isPieceWhite;
        }

    }
}

