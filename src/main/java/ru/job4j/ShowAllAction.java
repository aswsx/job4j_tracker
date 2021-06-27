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
    public boolean execute(Input input, SqlTracker memTracker) {
        out.println("=== Show all Items ===");
        List<Item> all = memTracker.findAll();
        for (Item item : all) {
            out.println(item);
        }
        return true;
    }
}
