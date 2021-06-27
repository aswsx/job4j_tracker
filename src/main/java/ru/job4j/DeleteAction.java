package ru.job4j;

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
    public boolean execute(Input input, SqlTracker memTracker) throws SQLException {
        out.println("=== Delete Item ===");
        var id = input.askInt("=== Enter Id ===");
        if (memTracker.delete(id)) {
            out.println("Deleted");
        } else {
            out.println("Error");
        }
        return true;
    }
}
