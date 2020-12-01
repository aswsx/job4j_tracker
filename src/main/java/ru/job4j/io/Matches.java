package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        int matchQty = 11;
        Scanner scan = new Scanner(System.in);
        int player = 1;

        while (matchQty > 0) {
            System.out.println("Введите число от 1 до 3");
            int select = Integer.parseInt(scan.nextLine());
            boolean isRight = (select >= 1 && select <= 3);
            if (isRight) {
                matchQty -= select;
                System.out.println("Ход " + player + " игрока");
                System.out.println("На столе " + matchQty + " спичек");
                if (matchQty <= 0) {
                    System.out.println("Игрок " + player + " выиграл");
                }
            }
            switch (player) {
                case 1:
                    player = 2;
                    break;
                case 2:
                    player = 1;
                    break;
                default:
                    break;
            }
        }
    }
}
