package ru.job4j;

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
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Delete Item ===");
        int id = input.askInt("=== Enter Id ===");
        if (tracker.delete(id)) {
            out.println("Deleted");
        } else {
            out.println("Error");
        }
        return true;
    }
}
