package ru.job4j;

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
