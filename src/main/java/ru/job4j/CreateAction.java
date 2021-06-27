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
    public boolean execute(Input input, SqlTracker memTracker) throws SQLException {
        out.println("=== Create new Item ===");
        String name = input.askStr("Enter name: ");
        var item = new Item(name);
        memTracker.add(item);
        return true;
    }
}

