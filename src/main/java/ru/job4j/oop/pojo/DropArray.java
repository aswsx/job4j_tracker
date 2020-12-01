package ru.job4j.oop.pojo;

import java.util.Arrays;

public class DropArray {
    public static void main(String[] args) {
        String[] names = {"Petr", null, "Ivan", "Stepan", null};
        String[] namesWithoutNull = new String[names.length];
        int size = 0;

        for (int index = 0; index < names.length; index++) {
            String name = names[index];
            if (name != null) {
                namesWithoutNull[size] = name;
                size++;
            }
        }
        namesWithoutNull = Arrays.copyOf(namesWithoutNull, size);
        for (int index = 0; index < namesWithoutNull.length; index++) {
            System.out.println(namesWithoutNull[index]);
        }
    }
}