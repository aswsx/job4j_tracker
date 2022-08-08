package ru.job4j.tracker.action;

import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.store.Store;
import ru.job4j.tracker.input.Input;

public class FindByIDAction implements UserAction {
    private final Output out;

    public FindByIDAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find by Id";
    }

    @Override
    public boolean execute(Input input, Store store) {
        out.println("=== Find item by Id ===");
        var id = input.askInt("=== Enter Id ===");
        var item = store.findById(id);
        if (item != null) {
            out.println(item);
        } else {
            out.println("Заявка с таким id не найдена");
        }
        return true;
    }
}
