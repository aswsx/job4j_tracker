package ru.job4j.tracker.sort;

import ru.job4j.tracker.model.Item;

import java.util.Comparator;

public class SortItemDownCreated implements Comparator<Item> {

    @Override
    public int compare(Item item1, Item item2) {
        return item2.getCreated().compareTo(item1.getCreated());
    }
}