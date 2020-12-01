package ru.job4j.tracker.collection;

import java.util.HashSet;
import java.util.List;

public class NotifyAccount {
    public static HashSet<Account> sent(List<Account> accounts) {
        return new HashSet<>(accounts);
    }
}
