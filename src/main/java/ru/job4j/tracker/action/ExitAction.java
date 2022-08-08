package ru.job4j.tracker.action;

import ru.job4j.tracker.store.Store;
import ru.job4j.tracker.input.Input;

public class ExitAction implements UserAction {

    @Override
    public String name() {
        return "Exit";
    }

    @Override
    public boolean execute(Input input, Store store) {
        return false;
    }
}
