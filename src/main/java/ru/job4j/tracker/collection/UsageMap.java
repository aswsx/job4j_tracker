package ru.job4j.tracker.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("pochta@ya.ru", "Vovochka");
        map.put("mail@mail.ru", "Vasya Pupkin");
        map.put("qwerty@mail.ru", "John Doe");

        for (String key : map.keySet()) {
            System.out.println(key + '=' + map.get(key));
        }
    }
}
