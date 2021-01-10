package ru.job4j.collection;

import java.util.List;

public class Article {
    public static boolean generateBy(String origin, String line) {
        List<String> sourceText = List.of(origin.split("\\s*(\\s|,|!|\\.)\\s*"));
        List<String> outText = List.of(line.split("\\s*(\\s|,|!|\\.)\\s*"));
        for (String str : outText) {
            if (!sourceText.contains(str)) {
                return false;
            }
        }
        return true;
    }
}
