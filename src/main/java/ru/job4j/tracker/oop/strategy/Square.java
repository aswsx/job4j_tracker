package ru.job4j.tracker.oop.strategy;

public class Square implements Shape {
    @Override
    public String draw() {
        String ln = System.lineSeparator();
        return    "________" + ln
                + "|      |" + ln
                + "|      |" + ln
                + "|______|";
    }
}
