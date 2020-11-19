package ru.job4j.tracker.oop.strategy;

public class Triangle implements Shape {

    @Override
    public String draw() {
        String ln = System.lineSeparator();
        return    "   ^   " + ln
                + " /   \\   " + ln
                + "/_____\\";
    }
}
