package ru.job4j.sort;

import ru.job4j.model.Item;

import java.util.Comparator;

public class SortItemUpName implements Comparator<Item> {

    @Override
    public int compare(Item item1, Item item2) {
        return item1.getName().compareTo(item2.getName());
    }
}
