package ru.job4j;

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
    public boolean execute(Input input, SqlTracker memTracker) {
        out.println("=== Find item by Id ===");
        var id = input.askInt("=== Enter Id ===");
        Item item = memTracker.findById(id);
        if (item != null) {
            out.println(item);
        } else {
            out.println("Заявка с таким id не найдена");
        }
        return true;
    }
}
