package ru.job4j;

public interface UserAction {
    String name();

    boolean execute(Input input, Tracker tracker);
    }
