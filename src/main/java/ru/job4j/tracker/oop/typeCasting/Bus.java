package ru.job4j.tracker.oop.typeCasting;

public class Bus implements Vehicle {

    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " is moving along the road");
    }
}
