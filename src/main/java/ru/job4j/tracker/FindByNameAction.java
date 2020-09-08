package ru.job4j.tracker;

public class FindByNameAction implements UserAction {

    @Override
    public String name() {
        return "=== Find item by Name ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("=== Enter name ===");
        Item[] items = tracker.findByName(name);
        if (items.length > 0) {
            for (int i = 0; i < items.length; i++) {
                System.out.println(items[i]);
            }
        } else {
            System.out.println("Заявки с таким именем не найдены");
        }
        return true;
    }
}
