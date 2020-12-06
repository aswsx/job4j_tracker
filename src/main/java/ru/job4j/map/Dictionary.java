package ru.job4j.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dictionary {
    public static Map<String, List<String>> collectData(String[] strings) {
        Map<String, List<String>> rsl = new HashMap<>();
        for (String str : strings) {
            String charAtFirstPos = String.valueOf(str.charAt(0));
            rsl.putIfAbsent(charAtFirstPos, new ArrayList<>());
            rsl.get(charAtFirstPos).add(str);
        }
        return rsl;
    }
}