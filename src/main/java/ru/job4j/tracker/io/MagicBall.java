package ru.job4j.tracker.io;

import java.util.Random;
import java.util.Scanner;

public class MagicBall {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Я великий оракул. Что ты хочешь узнать? ");
        String question = scan.nextLine();
        int answer = new Random().nextInt(3);
        switch (answer) {
            case 0 -> System.out.println("Да");
            case 1 -> System.out.println("Нет");
            default -> System.out.println("Может быть");
        }
    }
}
