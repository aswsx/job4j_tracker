package ru.job4j.tracker;

public class DeleteAction implements UserAction {

    @Override
    public String name() {
        return "=== Delete Item ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("=== Enter Id ===");
        if (tracker.delete(id)) {
            System.out.println("Deleted");
        } else {
            System.out.println("Error");
        }
        return true;
    }
}
