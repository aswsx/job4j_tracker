package ru.job4j.tracker.oop.inheritance;

public class TextReport {
    public String generate(String name, String body) {
        return name + System.lineSeparator() + body;
    }
}
