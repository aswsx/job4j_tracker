package ru.job4j.sort;

import ru.job4j.model.Item;

import java.util.Comparator;

public class SortItemDownId implements Comparator<Item> {

    @Override
    public int compare(Item item1, Item item2) {
        return Integer.compare(item2.getId(), item1.getId());
    }
}
