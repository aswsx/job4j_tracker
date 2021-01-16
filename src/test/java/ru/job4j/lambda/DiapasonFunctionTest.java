package ru.job4j.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class DiapasonFunctionTest {
    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = DiapasonFunction.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenQuadraticFunctionThenQuadraticResults() {
        List<Double> result = DiapasonFunction.diapason(1, 8, x -> 2 * x * x);
        List<Double> expected = Arrays.asList(2D, 8D, 18D, 32D, 50D, 72D, 98D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenExponentialFunctionThenExponentialResults() {
        List<Double> result = DiapasonFunction.diapason(2, 6, x -> 3 * x);
        List<Double> expected = Arrays.asList(6D, 9D, 12D, 15D);
        assertThat(result, is(expected));
    }
}