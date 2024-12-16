package org.example.figure;

import org.example.Board;
import org.example.Color;
import org.example.Coordinates;
import org.example.File;

import java.util.Scanner;
import java.util.Set;

public class InputCoordinates {
    private static final Scanner scanner = new Scanner(System.in);

    public static Coordinates input(){

        while(true)
        {

            String strCoordinates = scanner.nextLine();

            if(!(strCoordinates.length() ==2)){
                System.out.println("Неправильный ввод");
                continue;
            }

            char fileChar = strCoordinates.charAt(0);
            char rankChar = strCoordinates.charAt(1);

            if(!Character.isDigit(rankChar)||!Character.isLetter(fileChar)){
                System.out.println("Неправильный ввод");
                continue;
            }

            int rank = Character.getNumericValue(rankChar);
            if(rank<1||rank>8){
                System.out.println("Неправильный ввод");
                continue;
            }

            File file = File.checkInputLetter(fileChar);
            if(file == null){
                System.out.println("Неправильный ввод");
                continue;
            }

            return new Coordinates(file,rank);
        }
        
    }

    public static Coordinates inputCoordinatesForPieceColor(Color color, Board board){
        System.out.println("Введите координаты фигуры");

       while(true){
            Coordinates coordinates = input();
            if (board.isSquareEmpty(coordinates)) {
                System.out.println("Фигуры нет на введенном вами поле");
                continue;
            }

            Piece piece = board.getPiecesCoordinate(coordinates);
            if (piece.color != color) {
                System.out.println("Сейчас ходят:" + color);
                continue;
            }

            Set<Coordinates> availableMoveCoordinates = piece.getAvailableMoveCoordinates(board);

            if (availableMoveCoordinates.size() == 0) {
                System.out.println("Фигура не имеет ходов");
                continue;
            }

            return coordinates;
        }
    }


    public static Coordinates availableSquareForMove(Set<Coordinates> coordinates) {

        while (true){
            System.out.println("Сделайте ход");
            Coordinates input = input();
            if (!coordinates.contains(input)) {
                System.out.println("Недоступный ход");
                continue;
            }

            return input;
        }
    }
}
