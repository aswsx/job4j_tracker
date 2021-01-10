package ru.job4j.stream;

import java.util.List;
import java.util.Objects;

public class NoneMatchMethod {
    public static boolean check(List<String> list) {
        return list.stream()
                .noneMatch(s -> s.equals(""));
    }
}