package org.example;

public enum File {
    A, B, C, D, E, F, G, H;

    public static File checkInputLetter(char file){
        try {
            return File.valueOf(String.valueOf(file).toUpperCase());
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
