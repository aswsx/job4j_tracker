
package ru.job4j.stream;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MatrixToListTest {
    @Test
    public void convert() {
        Integer[][] input = {{1, 2, 3}, {3, 2, 1}};
        List<Integer> expect = List.of(1, 2, 3, 3, 2, 1);
        MatrixToList func = new MatrixToList();
        List<Integer> rsl = func.convert(input);
        assertThat(rsl, is(expect));
    }
}