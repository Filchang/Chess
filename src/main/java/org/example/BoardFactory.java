package org.example;

public class BoardFactory {
    private PieceFactory pieceFactory = new PieceFactory();
    public Board CheesFen(String fen){

        String[] fenSplit = fen.split(" ");
        String fenForPiecePosition = fenSplit[0];
        String[] fenRows = fenForPiecePosition.split("/");

        Board board = new Board();

        for (int i = 0; i < fenRows.length; i++) {
            String row = fenRows[i];
            int rank  = 8 - i;

            int fileIndex = 0;
            for (int j = 0; j < row.length(); j++) {
                char charFen = row.charAt(j);

                if(Character.isDigit(charFen)){
                    fileIndex += Character.getNumericValue(charFen);
                }
                else{
                    File file = File.values()[fileIndex];
                    Coordinates coordinates = new Coordinates(file,rank);

                    board.setPiece(coordinates,pieceFactory.pieceFromFen(charFen,coordinates));

                    fileIndex++;
                }
            }
        }
        return board;
    }
}
