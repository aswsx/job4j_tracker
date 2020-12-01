package ru.job4j.tracker.collection;

import java.util.HashSet;
import java.util.List;

public class FullSearch {
    public static HashSet<String> extractNumber(List<Task> list) {
        HashSet<String> numbers = new HashSet<>();
        for (Task elem : list) {
            numbers.add(elem.getNumber());
        }
        return numbers;
    }
}
