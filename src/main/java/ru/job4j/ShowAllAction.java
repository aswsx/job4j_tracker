package ru.job4j;

import java.util.List;

public class ShowAllAction implements UserAction {
    private final Output out;

    public ShowAllAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Show all";
    }

    @Override
    public boolean execute(Input input, Store store) {
        out.println("=== Show all Items ===");
        List<Item> all = store.findAll();
        for (Item item : all) {
            out.println(item);
        }
        return true;
    }
}
