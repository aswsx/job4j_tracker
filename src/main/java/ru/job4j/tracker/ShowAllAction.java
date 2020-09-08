package ru.job4j.tracker;

public class ShowAllAction implements UserAction {

    @Override
    public String name() {
        return "=== Show all Items ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item[] all = tracker.findAll();
        for (Item item : all) {
            System.out.println(item);
        }
        return true;
    }
}
