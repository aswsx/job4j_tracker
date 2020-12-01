package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        int leftComp = Integer.parseInt(left.split("[.]")[0]);
        int rightComp = Integer.parseInt(right.split("[.]")[0]);
        return Integer.compare(leftComp, rightComp);
    }
}