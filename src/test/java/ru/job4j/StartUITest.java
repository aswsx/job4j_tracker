package ru.job4j;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class StartUITest {
    @Test
    public void whenCreateItem() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[]{"0", "Created Item", "1"});
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new CreateAction(out));
        actions.add(new ExitAction());
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll().get(0).getName(), is("Created Item"));
    }

    @Test
    public void whenReplaceItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Created item"));
        String replName = "New item name";
        Input in = new StubInput(new String[]{"0", Integer.toString(item.getId()), replName, "1"});
        List<UserAction> actions = new ArrayList<>();
        actions.add(new EditAction(out));
        actions.add(new ExitAction());
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll().get(0).getName(), is(replName));
    }

    @Test
    public void whenDeleteItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted item"));
        Input in = new StubInput(new String[]{"0", Integer.toString(item.getId()), "1"});
        List<UserAction> actions = new ArrayList<>();
        actions.add(new DeleteAction(out));
        actions.add(new ExitAction());
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[]{"0"});
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new ExitAction());
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                String.format(
                        "Menu.%n"
                                + "0. Exit%n")));
    }

    @Test
    public void whenFindAllItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Input in = new StubInput(new String[]{"0", "1"});
        List<UserAction> actions = new ArrayList<>();
        actions.add(new ShowAllAction(out));
        actions.add(new ExitAction());
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                String.format(
                        "Menu.%n"
                                + "0. Show all%n"
                                + "1. Exit%n"
                                + "=== Show all Items ===%n"
                                + "Menu.%n"
                                + "0. Show all%n"
                                + "1. Exit%n")));
    }

    @Test
    public void whenFindByID() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Added item"));
        Input in = new StubInput(new String[]{"0", Integer.toString(item.getId()), "1"});
        List<UserAction> actions = new ArrayList<>();
        actions.add(new FindByIDAction(out));
        actions.add(new ExitAction());
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                String.format(
                        "Menu.%n"
                                + "0. Find by Id%n"
                                + "1. Exit%n"
                                + "=== Find item by Id ===%n"
                                + "Item{" + "id="
                                + item.getId()
                                + ", name='"
                                + item.getName()
                                + '\''
                                + ", created="
                                + item.getCreated().toString()
                                + "}%n"
                                + "Menu.%n"
                                + "0. Find by Id%n"
                                + "1. Exit%n")));
    }

    @Test
    public void whenFindByName() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Added item"));
        Input in = new StubInput(new String[]{"0", item.getName(), "1"});
        List<UserAction> actions = new ArrayList<>();
        actions.add(new FindByNameAction(out));
        actions.add(new ExitAction());
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                String.format(
                        "Menu.%n"
                                + "0. Find by Name%n"
                                + "1. Exit%n"
                                + "=== Find item by Name ===%n"
                                + "Item{" + "id="
                                + item.getId()
                                + ", name='"
                                + item.getName()
                                + '\''
                                + ", created="
                                + item.getCreated().toString()
                                + "}%n"
                                + "Menu.%n"
                                + "0. Find by Name%n"
                                + "1. Exit%n")));
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[]{"8", "0"});
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new ExitAction());
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                String.format(
                        "Menu.%n"
                                + "0. Exit%n"
                                + "Wrong input, you can select: 0 .. 0%n"
                                + "Menu.%n"
                                + "0. Exit%n"
                )
                )
        );
    }
}

