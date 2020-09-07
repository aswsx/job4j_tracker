package ru.job4j.tracker.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        int matchQty = 11;
        Scanner scan = new Scanner(System.in);

        while (matchQty > 0) {
            System.out.println("Введите число от 1 до 3");
            int select = Integer.parseInt(scan.nextLine());
            boolean isRight = (select >= 1 && select <= 3);
            if (isRight) {
                matchQty -= select;
                System.out.println("На столе " + matchQty + " спичек");
            }
        }
    }
}
