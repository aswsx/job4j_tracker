package ru.job4j.map;

import java.util.HashMap;
import java.util.Map;

public class NonUniqueString {
    public static Map<String, Boolean> checkData(String[] strings) {
        Map<String, Boolean> map = new HashMap<>();
        for (String  str : strings) {
            map.computeIfPresent(str, (key, val) -> true);
            map.putIfAbsent(str, false);
        }
        return map;
    }
}