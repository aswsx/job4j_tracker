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
