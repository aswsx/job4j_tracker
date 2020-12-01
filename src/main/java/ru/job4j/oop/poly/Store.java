package ru.job4j.oop.poly;

public interface Store {
    void save(String value);

    String[] load();
}
