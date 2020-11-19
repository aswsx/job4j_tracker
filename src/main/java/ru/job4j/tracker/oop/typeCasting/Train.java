package ru.job4j.tracker.oop.typeCasting;

public class Train implements Vehicle {

    @Override
    public void move() {
         System.out.println(getClass().getSimpleName() + " moves on the railroad");
    }
}
