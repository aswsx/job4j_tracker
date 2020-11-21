package ru.job4j.tracker;

import java.util.Comparator;

public class SortItemUpId implements Comparator<Item> {

    @Override
    public int compare(Item item1, Item item2) {
        return Integer.compare(item1.getId(), item2.getId());
    }
}
