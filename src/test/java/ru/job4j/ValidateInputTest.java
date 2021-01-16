package ru.job4j;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ValidateInputTest {

    @Test
    public void whenWordInsteadNumber() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[]{"one", "1"});
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(out.toString(), is(
                String.format(
                        "Please enter validate data again.%n")));
    }

    @Test
    public void whenWrongNumber() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[]{"8", "1"});
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(8));
    }

    @Test
    public void whenValidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[]{"1"});
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(1));
    }
}