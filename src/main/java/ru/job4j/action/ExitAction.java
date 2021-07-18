package ru.job4j.action;

import ru.job4j.store.Store;
import ru.job4j.input.Input;

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
