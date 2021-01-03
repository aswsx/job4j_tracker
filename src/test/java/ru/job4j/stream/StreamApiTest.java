package ru.job4j.stream;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class StreamApiTest {
    @Test
    public void onlyPosNumbers() {
        List<Integer> list = List.of(-3, -2, -1, 0, 1, 2, 3);
        List<Integer> expected = List.of(1, 2, 3);
        List<Integer> rsl = StreamApi.onlyPosNumbers(list);
        assertThat(rsl, is(expected));
    }
}