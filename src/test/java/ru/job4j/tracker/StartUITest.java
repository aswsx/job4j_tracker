package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class StartUITest {
    @Test
    public void whenCreateItem() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[]{"0", "Item name", "1"});
        Tracker tracker = new Tracker();
        // UserAction[] actions = {new CreateAction(out), new ExitAction(out)};
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new CreateAction(out));
        actions.add(new ExitAction(out));
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll().get(0).getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        Input in = new StubInput(new String[]{"0", Integer.toString(item.getId()), replacedName, "1"});
        // UserAction[] actions = {new EditAction(out), new ExitAction(out)};
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new EditAction(out));
        actions.add(new ExitAction(out));
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll().get(0).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted item"));
       // String id = String.valueOf(item.getId());
        Input in = new StubInput(new String[]{"0", Integer.toString(item.getId()), "1"});
        // UserAction[] actions = {new DeleteAction(out), new ExitAction(out)};
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new DeleteAction(out));
        actions.add(new ExitAction(out));
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[]{"0"});
        Tracker tracker = new Tracker();
        // UserAction[] actions = {new ExitAction(out)};
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new ExitAction(out));
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
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new ShowAllAction(out));
        actions.add(new ExitAction(out));
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
       // String id = String.valueOf(item.getId());
        Input in = new StubInput(new String[]{"0", Integer.toString(item.getId()), "1"});
        //  UserAction[] actions = {new FindByIDAction(out), new ExitAction(out)};
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new FindByIDAction(out));
        actions.add(new ExitAction(out));
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                String.format(
                        "Menu.%n"
                                + "0. Find by Id%n"
                                + "1. Exit%n"
                                + "=== Find item by Id ===%n"
                                + tracker.findById(item.getId()) + System.lineSeparator()
                                + "Menu.%n"
                                + "0. Find by Id%n"
                                + "1. Exit%n")));
    }

    @Test
    public void whenFindByName() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Added item"));
        String name = String.valueOf(item.getName());
        Input in = new StubInput(new String[]{"0", name, "1"});
        //UserAction[] actions = {new FindByNameAction(out), new ExitAction(out)};
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new FindByIDAction(out));
        actions.add(new ExitAction(out));
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                String.format(
                        "Menu.%n"
                                + "0. Find by Name%n"
                                + "1. Exit%n"
                                + "=== Find item by Name ===%n"
                                + tracker.findById(item.getId()) + System.lineSeparator()
                                + "Menu.%n"
                                + "0. Find by Name%n"
                                + "1. Exit%n")));
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[]{"8", "0"});
        Tracker tracker = new Tracker();
        //  UserAction[] actions = {new ExitAction(out)};
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new ExitAction(out));
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

