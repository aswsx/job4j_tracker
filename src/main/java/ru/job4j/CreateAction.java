package ru.job4j;

import java.sql.SQLException;

public class CreateAction implements UserAction {
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

