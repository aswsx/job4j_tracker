package ru.job4j.tracker.action;

import ru.job4j.tracker.model.Item;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.store.Store;
import ru.job4j.tracker.input.Input;

import java.util.List;

public class FindByNameAction implements UserAction {
    private final Output out;

    public FindByNameAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find by Name";
    }

    @Override
    public boolean execute(Input input, Store store) {
        out.println("=== Find item by Name ===");
        String name = input.askStr("=== Enter name ===");
        List<Item> items = store.findByName(name);
        if (!items.isEmpty()) {
            for (Item item : items) {
                out.println(item);
            }
        } else {
            out.println("Заявки с таким именем не найдены");
        }
        return true;
    }
}
