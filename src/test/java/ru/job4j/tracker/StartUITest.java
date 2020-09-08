package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class StartUITest {
    @Test
    public void whenCreateItem() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[]{"0", "Item name", "1"});
        Tracker tracker = new Tracker();
        UserAction[] actions = {new CreateAction(out), new ExitAction(out)};
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced item"));
        String id = String.valueOf(item.getId());
        String replacedName = "New item name";
        Input in = new StubInput(new String[]{"0", id, replacedName, "1"});
        UserAction[] actions = {new EditAction(out), new ExitAction(out)};
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted item"));
        String id = String.valueOf(item.getId());
        Input in = new StubInput(new String[]{"0", id, "1"});
        UserAction[] actions = {new DeleteAction(out), new ExitAction(out)};
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[]{"0"});
        Tracker tracker = new Tracker();
        UserAction[] actions = {new ExitAction(out)};
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu." + System.lineSeparator() + "0. Exit" + System.lineSeparator()));
    }

    @Test
    public void whenFindAllItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Added item"));
        String id = String.valueOf(item.getId());
        Input in = new StubInput(new String[]{"0", "1"});
        UserAction[] actions = {new ShowAllAction(out), new ExitAction(out)};
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu." + System.lineSeparator() + "0. Show all" + System.lineSeparator() + "1. Exit" + System.lineSeparator()
                + "=== Show all Items ===" + System.lineSeparator() + tracker.findById(item.getId()) + System.lineSeparator()
                + "Menu." + System.lineSeparator() + "0. Show all" + System.lineSeparator() + "1. Exit" + System.lineSeparator()));
    }

    @Test
    public void whenFindByID() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Added item"));
        String id = String.valueOf(item.getId());
        Input in = new StubInput(new String[]{"0", id, "1"});
        UserAction[] actions = {new FindByIDAction(out), new ExitAction(out)};
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu." + System.lineSeparator() + "0. Find by Id" + System.lineSeparator() + "1. Exit" + System.lineSeparator()
                + "=== Find item by Id ===" + System.lineSeparator() + tracker.findById(item.getId()) + System.lineSeparator()
                + "Menu." + System.lineSeparator() + "0. Find by Id" + System.lineSeparator() + "1. Exit" + System.lineSeparator()));
    }

    @Test
    public void whenFindByName() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Added item"));
        String name = String.valueOf(item.getName());
        Input in = new StubInput(new String[]{"0", name, "1"});
        UserAction[] actions = {new FindByNameAction(out), new ExitAction(out)};
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu." + System.lineSeparator() + "0. Find by Name" + System.lineSeparator() + "1. Exit" + System.lineSeparator()
                + "=== Find item by Name ===" + System.lineSeparator() + tracker.findById(item.getId()) + System.lineSeparator()
                + "Menu." + System.lineSeparator() + "0. Find by Name" + System.lineSeparator() + "1. Exit" + System.lineSeparator()));
    }
}