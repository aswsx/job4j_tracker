package ru.job4j.oop.typecasting;

public class Bus implements Vehicle {

    @Override
    public void move() {
         System.out.println(getClass().getSimpleName() + " is moving along the road");
    }
}
