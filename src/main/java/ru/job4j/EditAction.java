package ru.job4j;

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
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Edit Item ===");
        int id = input.askInt("Enter Id:");
        String name = input.askStr("Enter name:");
        Item item = new Item(name);
        if (tracker.replace(id, item)) {
            out.println("Edited");
        } else {
            out.println("Error");
        }
        return true;
    }
}
