package ru.job4j.collection;

import java.util.List;
import java.util.stream.Collectors;

public class FreezeStr {
    public static boolean eq(String left, String right) {
        List<Character> leftList = left.chars()
                .mapToObj(c -> (char) c)
                .sorted()
                .collect(Collectors.toList());

        List<Character> rightList = right.chars()
                .mapToObj(c -> (char) c)
                .sorted()
                .collect(Collectors.toList());

        return leftList.equals(rightList);
    }
}