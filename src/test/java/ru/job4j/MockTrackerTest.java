package ru.job4j;

import org.junit.Test;
import ru.job4j.action.DeleteAction;
import ru.job4j.action.EditAction;
import ru.job4j.action.FindByIDAction;
import ru.job4j.action.FindByNameAction;
import ru.job4j.input.Input;
import ru.job4j.model.Item;
import ru.job4j.output.Output;
import ru.job4j.output.StubOutput;
import ru.job4j.store.MemTracker;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author Alex Gutorov
 * @version 1.0
 * @created 03/04/2022 - 12:15
 */
public class MockTrackerTest {

    @Test
    public void whenEditItem() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        EditAction rep = new EditAction(out);

        Input input = mock(Input.class);

        when(input.askInt(any(String.class))).thenReturn(1);
        when(input.askStr(any(String.class))).thenReturn(replacedName);

        rep.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Edit Item ===" + ln + "Edited" + ln));
        assertThat(tracker.findAll().get(0).getName(), is(replacedName));
    }

    @Test
    public void whenFindById() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = new Item("Item");
        tracker.add(item);
        FindByIDAction rep = new FindByIDAction(out);

        Input input = mock(Input.class);

        when(input.askInt(any(String.class))).thenReturn(1);

        rep.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(tracker.findById(item.getId()), is(item));
        assertThat(out.toString(), is("=== Find item by Id ===" + ln + item + ln));
    }

    @Test
    public void whenFindNameId() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = new Item("Item");
        tracker.add(item);
        FindByNameAction rep = new FindByNameAction(out);

        Input input = mock(Input.class);

        when(input.askStr(any(String.class))).thenReturn("Item");

        rep.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(tracker.findById(item.getId()), is(item));
        assertThat(out.toString(), is("=== Find item by Name ===" + ln + item + ln));
    }

    @Test
    public void whenDeleteItem() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = new Item("Item");
        tracker.add(item);
        DeleteAction rep = new DeleteAction(out);

        Input input = mock(Input.class);

        when(input.askInt(any(String.class))).thenReturn(1);

        rep.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Delete Item ===" + ln + "Deleted" + ln));
        assertNull(tracker.findById(item.getId()));
    }
}


