package ru.job4j.stream;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ProfilesTest {
    @Test
    public void whenDifferentAddresses() {
        Profiles func = new Profiles();
        List<Address> expect = List.of(
                new Address("Алматы"),
                new Address("Караганда"),
                new Address("Москва"),
                new Address("Нур-Султан")
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
                new Address("Алматы"),
                new Address("Алматы"),
                new Address("Москва"),
                new Address("Нур-Султан")
        );
        List<Profile> input = list.stream()
                .map(Profile::new)
                .collect(Collectors.toList());
        List<Address> expect = List.of(
                new Address("Алматы"),
                new Address("Москва"),
                new Address("Нур-Султан")
        );
        List<Address> rsl = func.collect(input);
        assertThat(rsl, is(expect));
    }
}