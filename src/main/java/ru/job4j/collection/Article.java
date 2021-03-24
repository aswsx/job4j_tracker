package ru.job4j.collection;

import java.util.Arrays;
import java.util.HashSet;

public class Article {
    public static boolean generateBy(String origin, String line) {
        HashSet<String> sourceText = new HashSet<>(Arrays
                .asList(origin.
                        replaceAll("\\p{P}", "").
                        split("\\p{Z}")));
        HashSet<String> outText = new HashSet<>(Arrays
                .asList(line.
                        replaceAll("\\p{P}", "").
                        split("\\p{Z}")));
        for (String str : outText) {
            if (!sourceText.contains(str)) {
                return false;
            }
        }
        return true;
    }
}
