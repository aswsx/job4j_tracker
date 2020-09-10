package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ValidateInputTest {

    @Test
    public void whenWordInsteadNumber() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[]{"one", "1"});
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(out.toString(), is("Please enter validate data again."));
    }

    @Test
    public void whenWWrongNumber() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[]{"8", "1"});
        ValidateInput input = new ValidateInput(out, in);
        assertThat(out.toString(), is("Please enter validate data again."));
    }

    @Test
    public void whenValidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[]{"1"});
        ValidateInput input = new ValidateInput(out, in);
        assertThat(out.toString(), is("Please enter validate data again."));
    }

    @Test
    public void whenOutput() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[]{"0", "1"});
        Tracker tracker = new Tracker();
        UserAction[] actions = {new ExitAction(out)};
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Please enter validate data again."));
    }
}