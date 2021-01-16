package ru.job4j.collection;

import org.junit.Test;

import java.util.HashSet;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class NotifyAccountTest {

    @Test
    public void sentUnique() {
        List<Account> accounts = List.of(
                new Account("123", "Petr Arsentev", "eDer3432f"),
                new Account("142", "Petr Arsentev", "000001")
        );
        HashSet<Account> expect = new HashSet<>(
                List.of(
                        new Account("123", "Petr Arsentev", "eDer3432f"),
                        new Account("142", "Petr Arsentev", "000001")
                )
        );
        assertThat(NotifyAccount.sent(accounts), is(expect));
    }

    @Test
    public void sentNotUnique() {
        List<Account> accounts = List.of(
                new Account("123", "Petr Arsentev", "eDer3432f"),
                new Account("123", "Petr Arsentev", "eDer3432f"),
                new Account("123", "Petr Arsentev", "000001")

        );
        HashSet<Account> expect = new HashSet<>(
                List.of(
                        new Account("123", "Petr Arsentev", "eDer3432f"),
                        new Account("123", "Petr Arsentev", "000001")
                )
        );
        assertThat(NotifyAccount.sent(accounts), is(expect));
    }

    @Test
    public void sentDouble() {
        List<Account> accounts = List.of(
                new Account("123", "Petr Arsentev", "eDer3432f"),
                new Account("123", "Petr Arsentev", "eDer3432f")

        );
        HashSet<Account> expect = new HashSet<>(
                List.of(
                        new Account("123", "Petr Arsentev", "eDer3432f")
                )
        );
        assertThat(NotifyAccount.sent(accounts), is(expect));
    }
}