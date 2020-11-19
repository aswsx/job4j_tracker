package ru.job4j.tracker.oop.poly;

public interface Store {
    void save(String value);

    String[] load();
}
