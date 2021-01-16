package ru.job4j.stream;

import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ListToMapTest {
    @Test
    public void convert() {
        List<Student> input = List.of(
                new Student(1, "Челентано"),
                new Student(2, "Делон"),
                new Student(3, "Депардье"),
                new Student(4, "Ришар")
        );
        Map<String, Student> rsl = ListToMap.convert(input);
        Map expect = Map.of(
                "Челентано", new Student(1, "Челентано"),
                "Делон", new Student(2, "Делон"),
                "Депардье", new Student(3, "Депардье"),
                "Ришар", new Student(4, "Ришар")
        );
        assertThat(rsl, is(expect));
    }
}
