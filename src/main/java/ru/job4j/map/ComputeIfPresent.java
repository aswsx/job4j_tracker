package ru.job4j.map;

import java.util.Map;

public class ComputeIfPresent {
    public static Map<Integer, String> collectData(
            Map<Integer, String> name, Map<Integer, String> surname) {
        for (int ind : name.keySet()) {
            name.computeIfPresent(ind, (key, value) -> value + " " + surname.get(ind));
        }
        return name;
    }
}