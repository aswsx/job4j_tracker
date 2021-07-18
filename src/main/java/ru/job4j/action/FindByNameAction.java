package ru.job4j.action;

import ru.job4j.model.Item;
import ru.job4j.output.Output;
import ru.job4j.store.Store;
import ru.job4j.input.Input;

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
