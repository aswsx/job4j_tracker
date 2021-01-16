package ru.job4j.stream;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ProfilesTest {
    @Test
    public void whenDifferentAddresses() {
        Profiles func = new Profiles();
        List<Address> expect = List.of(
                new Address("Алматы", "Нурмакова", 30, 3),
                new Address("Караганда", "Ленина", 21, 14),
                new Address("Москва", "ак. Королева", 12, 1),
                new Address("Нур-Султан", "Мира", 23, 12)
        );
        List<Profile> input = expect.stream()
                .map(Profile::new)
                .collect(Collectors.toList());
        List<Address> rsl = func.collect(input);
        assertThat(rsl, is(expect));
    }

    @Test
    public void whenSameAddresses() {
        Profiles func = new Profiles();
        List<Address> list = List.of(
                new Address("Алматы", "Нурмакова", 30, 3),
                new Address("Алматы", "Нурмакова", 30, 3),
                new Address("Москва", "ак. Королева", 12, 1),
                new Address("Нур-Султан", "Мира", 23, 12)
        );
        List<Profile> input = list.stream()
                .map(Profile::new)
                .collect(Collectors.toList());
        List<Address> expect = List.of(
                new Address("Алматы", "Нурмакова", 30, 3),
                new Address("Москва", "ак. Королева", 12, 1),
                new Address("Нур-Султан", "Мира", 23, 12)
        );
        List<Address> rsl = func.collect(input);
        assertThat(rsl, is(expect));
    }
}