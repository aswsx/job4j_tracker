package ru.job4j.tracker.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        return Integer.compare(Integer.parseInt(left.split("[.]")[0]), Integer.parseInt(right.split("[.]")[0]));
    }
}