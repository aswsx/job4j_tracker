package ru.job4j.tracker.action;

import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.store.Store;
import ru.job4j.tracker.input.Input;

import java.sql.SQLException;

public class DeleteAction implements UserAction {
    private final Output out;

    public DeleteAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete Item";
    }

    @Override
    public boolean execute(Input input, Store store) {
        out.println("=== Delete Item ===");
        var id = input.askInt("=== Enter Id ===");
        try {
            if (store.delete(id)) {
                out.println("Deleted");
            } else {
                out.println("Error");
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return true;
    }
}
