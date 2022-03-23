package ru.job4j;

import ru.job4j.action.*;
import ru.job4j.input.ConsoleInput;
import ru.job4j.input.Input;
import ru.job4j.input.ValidateInput;
import ru.job4j.model.Item;
import ru.job4j.output.ConsoleOutput;
import ru.job4j.output.Output;
import ru.job4j.store.SqlTracker;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

public class StartUI {
    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }

    public void init(Input input, SqlTracker sqlTracker, List<UserAction> actions) {
        var run = true;
        while (run) {
            this.showMenu(actions);
            var select = input.askInt("Select: ");
            if (select < 0 || select > actions.size()) {
                out.println("Wrong input, you can select: 0 .. " + (actions.size() - 1));
                continue;
            }
            UserAction action = actions.get(select);
            run = action.execute(input, sqlTracker);
        }
    }

    private void showMenu(List<UserAction> actions) {
        out.println("Menu.");
        for (var i = 0; i < actions.size(); i++) {
            out.println(i + ". " + actions.get(i).name());
        }
    }

    public static void main(String[] args) {
        var item = new Item(Timestamp.valueOf(LocalDateTime.now()));
        System.out.println(item.getCreated());
        Output output = new ConsoleOutput();
        Input input = new ValidateInput(output, new ConsoleInput());
        try (var tracker = new SqlTracker()) {
            tracker.init();
            List<UserAction> actions = List.of(
                    new CreateAction(output),
                    new EditAction(output),
                    new DeleteAction(output),
                    new ShowAllAction(output),
                    new FindByIDAction(output),
                    new FindByNameAction(output),
                    new ExitAction()
            );
            new StartUI(output).init(input, tracker, actions);
        } catch (Exception e) {
            e.printStackTrace();
        }
/* использовано для профилирования памяти
        try (MemTracker memTracker = new MemTracker()) {
            for (int i = 0; i < 10000000; i++) {
                Item item = new Item();
                item.setName("z" + i);
                memTracker.add(item);
                int id = item.getId();
                memTracker.delete(id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
*/
    }
}

