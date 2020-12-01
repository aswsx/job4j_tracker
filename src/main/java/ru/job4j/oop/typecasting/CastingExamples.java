package ru.job4j.oop.typecasting;

public class CastingExamples {

    public static void main(String[] args) {
        Vehicle bus = new Bus();
        Vehicle plane = new Airplane();
        Vehicle train = new Train();

         Vehicle[] vehicles = new Vehicle[]{bus, plane, train};

        for (Vehicle v : vehicles) {
            v.move();
        }
    }
}

