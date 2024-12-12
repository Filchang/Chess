package org.example.figure;

import org.example.Board;
import org.example.Color;
import org.example.Coordinates;

import java.util.HashSet;
import java.util.Set;

abstract public class Piece {
    public Color color;
    public Coordinates coordinates;

    public Piece(Color color, Coordinates coordinates) {
        this.color = color;
        this.coordinates = coordinates;
    }

    public Set<Coordinates> getAvailableMoveCoordinates(Board board) {
        Set<Coordinates> result = new HashSet<>();

        for (CoordinatesShift shift : getPieceMove()) {
            if (coordinates.canShift(shift)) {
                Coordinates newCoordinates = coordinates.shift(shift);

                if (isSquareAvailableForMove(newCoordinates, board)) {
                    result.add(newCoordinates);
                }
            }
        }
        return result;
    }

    protected abstract Set<CoordinatesShift> getPieceMove();

    public boolean isSquareAvailableForMove(Coordinates coordinates, Board board){
        return board.isSquareEmpty(coordinates) || board.getPiecesCoordinate(coordinates).color != color;
    }


}

