package org.example;

import org.example.figure.CoordinatesShift;

import java.util.Objects;

public class Coordinates {
    public final File file;
    public final Integer rank;

    public Coordinates(File file, Integer rank) {
        this.file = file;
        this.rank = rank;
    }

    public Coordinates shift(CoordinatesShift shift){
        return new Coordinates(File.values()[this.file.ordinal() + shift.fileShift],this.rank+shift.rankShift);
    }

    public boolean canShift(CoordinatesShift shift){
        int f = file.ordinal() + shift.fileShift;
        int r = rank + shift.rankShift;

        if(f<0 || f>7) return false;
        if(r<1 || r>8) return false;

        return true;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Coordinates that = (Coordinates) object;
        return file == that.file && Objects.equals(rank, that.rank);
    }

    @Override
    public int hashCode() {
        return Objects.hash(file, rank);
    }
}
