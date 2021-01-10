package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;

public class TakeWhileMethod {
    public static List<Integer> takeWhile(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .takeWhile(n -> n < 0)
                .collect(Collectors.toList());
    }
}
