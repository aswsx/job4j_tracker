package ru.job4j.stream;

import java.util.List;
import java.util.stream.IntStream;

public class MapToIntMethod {
    public static long sum(List<Character> characters) {
        return characters.stream()
                .mapToInt(n -> (int) n)
                .sum();
    }
}