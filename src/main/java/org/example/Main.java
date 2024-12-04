package org.example;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        board.setupDefaultPiecePositions();
        BoardClassConsoleRenderer boardClassConsoleRenderer = new BoardClassConsoleRenderer();
        boardClassConsoleRenderer.render(board);
        int a = 123;
    }
}