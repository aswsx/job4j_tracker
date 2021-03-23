package ru.job4j.collection;

import java.util.Arrays;
import java.util.HashSet;

public class Article {
    public static boolean generateBy(String origin, String line) {
        HashSet<String> sourceText = new HashSet<>(Arrays
                .asList(origin.split("\\s*(\\s|,|!|\\.)\\s*")));
        HashSet<String> outText = new HashSet<>(Arrays.asList(line.split("\\s*(\\s|,|!|\\.)\\s*")));
        for (String str : outText) {
            if (!sourceText.toString().contains(str)) {
                return false;
            }
        }
        return true;
    }
}
