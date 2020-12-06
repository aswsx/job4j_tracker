package ru.job4j.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Concordance {
    public static Map<Character, List<Integer>> collectCharacters(String s) {
        s = s.replaceAll("\\s+", "");
        Map<Character, List<Integer>> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            map.putIfAbsent(chars[i], new ArrayList<>());
            map.get(chars[i]).add(i);
        }
        return map;
    }
}