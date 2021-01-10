package ru.job4j.stream;

import java.util.Objects;

/**
 * Класс Tuple содержит результаты: имя и баллы.
 * Этот класс используется как для учеников, так и для предметов.
 */

public class Tuple {
    private final String name;
    private final double score;

    public Tuple(String name, double score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Tuple tuple = (Tuple) o;
        return Double.compare(tuple.score, score) == 0
                && Objects.equals(name, tuple.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, score);
    }

    public double getScore() {
        return score;
    }
}