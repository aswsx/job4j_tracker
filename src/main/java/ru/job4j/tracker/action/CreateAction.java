package ru.job4j.tracker.action;

import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.model.Item;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.store.Store;

import java.sql.SQLException;

public class CreateAction implements UserAction {
    private Item item;
    private final Output out;

    public CreateAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Create";
    }

    @Override
    public boolean execute(Input input, Store store) {
        out.println("=== Create new Item ===");
        String name = input.askStr("Enter name: ");
        var item = new Item(name);
        try {
            store.add(item);
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return true;
    }
}

