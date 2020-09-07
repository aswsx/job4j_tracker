package ru.job4j.tracker.ru.job4j.oop.poly;

public interface Store {
    void save(String value);

    String[] load();
}
