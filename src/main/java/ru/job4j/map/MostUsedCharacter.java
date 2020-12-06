package ru.job4j.map;

import java.util.*;

public class MostUsedCharacter {
    public static char getMaxCount(String str) {
        Map<Character, Integer> letters = new HashMap<>();
        str = str.toLowerCase();
        str = str.replaceAll("\\s+", "");
        char[] chars = str.toCharArray();
        char rsl = ' ';
        int counter = 0;
        for (char letter : chars) {
            letters.computeIfPresent(letter, (key, value) -> value + 1);
            letters.putIfAbsent(letter, 0);
        }
        for (char key : letters.keySet()) {
            if (letters.get(key) > counter) {
                rsl = key;
                counter = letters.get(key);
            }
        }
        return rsl;
    }
}