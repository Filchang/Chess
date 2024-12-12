package org.example.figure;

import org.example.Color;
import org.example.Coordinates;

import java.util.Set;

public class Rook extends Piece {
    public Rook(Color color, Coordinates coordinates) {
        super(color, coordinates);
    }

    @Override
    protected Set<CoordinatesShift> getPieceMove() {
        return Set.of();
    }
}
