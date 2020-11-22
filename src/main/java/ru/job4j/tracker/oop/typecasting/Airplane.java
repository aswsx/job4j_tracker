package ru.job4j.tracker.oop.typecasting;

public class Airplane implements Vehicle {

    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " flies through the air");
    }
}
