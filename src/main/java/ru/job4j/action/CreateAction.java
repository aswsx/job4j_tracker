package ru.job4j.action;

import ru.job4j.input.Input;
import ru.job4j.model.Item;
import ru.job4j.output.Output;
import ru.job4j.store.Store;

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

