package ru.job4j.tracker;

public class EditAction implements UserAction {

    @Override
    public String name() {
        return "=== Edit Item ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("=== Enter Id ===");
        String name = input.askStr("=== Enter name ===");
        Item item = new Item(name);
        if (tracker.replace(id, item)) {
            System.out.println("Edited");
        } else {
            System.out.println("Error");
        }
        return true;
    }
}
