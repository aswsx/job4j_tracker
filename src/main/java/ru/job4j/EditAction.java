package ru.job4j;

import java.sql.SQLException;

public class EditAction implements UserAction {
    private final Output out;

    public EditAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Edit";
    }

    @Override
    public boolean execute(Input input, Store store) {
        out.println("=== Edit Item ===");
        var id = input.askInt("Enter Id:");
        String name = input.askStr("Enter name:");
        var item = new Item(name);
        try {
            if (store.replace(id, item)) {
                out.println("Edited");
            } else {
                out.println("Error");
            }
        } catch (SQLException es) {
            es.printStackTrace();
        }
        return true;
    }
}
