package ru.job4j.stream;

/**
 * Класс Subject описывает школьный предмет и аттестационный балл ученика.
 */

public class Subject {
    private final String name;
    private final int score;

    public Subject(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }
}